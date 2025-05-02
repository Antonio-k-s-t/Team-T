package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.enums.Roles;
import bg.sap.trohar_delivery.model.*;
import bg.sap.trohar_delivery.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        try {
            User user = userService.getUserByUsername(username);
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {
                model.addAttribute("user", user);
                return "redirect:/profile";
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }


    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String processRegistration(@RequestParam String fullname,
                                      @RequestParam String newUsername,
                                      @RequestParam String newPassword,
                                      @RequestParam String role,
                                      Model model) {
        try {
            if (userService.findUserByUsername(newUsername).isPresent()) {
                model.addAttribute("error", "Username already exists");
                return "signup";
            }
            userService.registerUser(fullname, newUsername, newPassword, role);

            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String processLogout() {
        return "redirect:/login";
    }
}