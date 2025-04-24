package bg.sap.trohar_delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String home() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {return "signup";}
}