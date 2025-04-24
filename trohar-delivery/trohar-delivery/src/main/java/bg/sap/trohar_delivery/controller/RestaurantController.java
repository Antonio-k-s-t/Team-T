package bg.sap.trohar_delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
    @GetMapping("/restaurant")
    public String home() {
        return "restaurant";
    }
}