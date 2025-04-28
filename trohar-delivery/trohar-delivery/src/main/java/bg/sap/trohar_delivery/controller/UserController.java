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
            if (userService.getUserByUsername(newUsername) != null) {
                model.addAttribute("error", "Username already exists");
                return "signup";
            }

            User user;
            Roles userRole;
            switch (role.toLowerCase()) {
                case "customer":
                    user = new Customer();
                    userRole = Roles.CUSTOMER;
                    break;
                case "admin":
                    user = new Admin();
                    userRole = Roles.ADMIN;
                    break;
                case "driver":
                    user = new Driver();
                    userRole = Roles.DRIVER;
                    break;
                default:
                    model.addAttribute("error", "Invalid role selected");
                    return "signup";
            }

            user.setUsername(newUsername);
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setRole(userRole);

            userService.registerUser(user);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        String username = "currentUser";
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String processLogout() {
        return "redirect:/login";
    }
}