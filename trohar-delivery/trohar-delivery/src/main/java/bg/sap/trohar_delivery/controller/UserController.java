package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.model.*;
import bg.sap.trohar_delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
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

    @GetMapping("/employee")
    public String showEmployee(){
        return "employee";
    }
}