package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.enums.ProductTypes;
import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", ProductTypes.values());
        return "products/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "products/view";
    }

    @GetMapping("/search")
    public String searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) ProductTypes type,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            Model model) {

        model.addAttribute("products",
                productService.searchProducts(name, description, type, minPrice, maxPrice));
        return "products/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("productTypes", ProductTypes.values());
        return "products/edit";
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products/" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @PostMapping("/{productId}/menus/{menuId}")
    public String addToMenu(@PathVariable Long productId, @PathVariable Long menuId) {
        productService.addMenuToProduct(productId, menuId);
        return "redirect:/products/" + productId;
    }

    @DeleteMapping("/{productId}/menus/{menuId}")
    public String removeFromMenu(@PathVariable Long productId, @PathVariable Long menuId) {
        productService.removeMenuFromProduct(productId, menuId);
        return "redirect:/products/" + productId;
    }

    @GetMapping("/menu/{menuId}")
    public String getProductsByMenu(@PathVariable Long menuId, Model model) {
        model.addAttribute("products", productService.getProductsByMenu(menuId));
        return "products/list";
    }
}