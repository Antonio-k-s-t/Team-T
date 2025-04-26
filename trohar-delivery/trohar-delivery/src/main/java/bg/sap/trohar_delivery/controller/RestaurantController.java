package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.model.Restaurant;
import bg.sap.trohar_delivery.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String viewRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "restaurant";
    }

    @GetMapping("/{id}")
    public String viewRestaurantDetails(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("restaurant", restaurantService.getRestaurantById(id));
            return "restaurant";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/restaurants";
        }
    }

    @GetMapping("/search")
    public String searchRestaurants(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            Model model) {
        model.addAttribute("restaurants",
                restaurantService.searchRestaurants(name, address));
        return "restaurant";
    }

    @GetMapping("/{id}/orders")
    public String viewRestaurantOrders(@PathVariable Long id, Model model) {
        try {
            Restaurant restaurant = restaurantService.getRestaurantById(id);
            model.addAttribute("restaurant", restaurant);
            model.addAttribute("orders", restaurant.getOrders());
            return "restaurant";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/restaurants";
        }
    }
}