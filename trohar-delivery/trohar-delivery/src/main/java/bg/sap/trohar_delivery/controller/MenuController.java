package bg.sap.trohar_delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("мену")
    public String showMenu() {

        return "menu";
    }
}