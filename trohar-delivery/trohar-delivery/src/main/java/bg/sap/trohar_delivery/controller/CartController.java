package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        Long customerId = 1L;
        List<Product> cartItems = cartService.getCartItems(customerId);
        model.addAttribute("cartItems", cartItems);

        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long productId) {
        Long customerId = 1L;
        cartService.addItem(customerId, productId);
        return "redirect:/cart";
    }
}