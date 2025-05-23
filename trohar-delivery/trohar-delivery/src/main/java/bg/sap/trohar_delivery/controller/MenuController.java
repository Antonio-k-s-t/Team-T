package bg.sap.trohar_delivery.controller;

import bg.sap.trohar_delivery.model.Menu;
import bg.sap.trohar_delivery.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public String getAllMenus(Model model) {
        model.addAttribute("menu", menuService.getAllMenus());
        return "menu";
    }

    @GetMapping("/api/menu")
    @ResponseBody
    public List<Menu> getMenuItemsJson() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public String getMenuById(@PathVariable Long id, Model model) {
        model.addAttribute("menu", menuService.getMenuById(id));
        return "menu/details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "menu/create";
    }

    @PostMapping
    public String createMenu(@ModelAttribute Menu menu) {
        menuService.createMenu(menu);
        return "redirect:/menu";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("menu", menuService.getMenuById(id));
        return "menu/edit";
    }

    @PostMapping("/{id}")
    public String updateMenu(@PathVariable Long id, @ModelAttribute Menu menu) {
        menuService.updateMenuBasicInfo(id, menu);
        return "redirect:/menu/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return "redirect:/menu";
    }

    @PostMapping("/{menuId}/products/{productId}")
    public String addProductToMenu(
            @PathVariable Long menuId,
            @PathVariable Long productId) {
        menuService.addProductToMenu(menuId, productId);
        return "redirect:/menu/" + menuId;
    }

    @PostMapping("/{menuId}/products/{productId}/remove")
    public String removeProductFromMenu(
            @PathVariable Long menuId,
            @PathVariable Long productId) {
        menuService.removeProductFromMenu(menuId, productId);
        return "redirect:/menu/" + menuId;
    }

    @PostMapping("/{menuId}/restaurants/{restaurantId}")
    public String addRestaurantToMenu(
            @PathVariable Long menuId,
            @PathVariable Long restaurantId) {
        menuService.addRestaurantToMenu(menuId, restaurantId);
        return "redirect:/menu/" + menuId;
    }

    @PostMapping("/{menuId}/restaurants/{restaurantId}/remove")
    public String removeRestaurantFromMenu(
            @PathVariable Long menuId,
            @PathVariable Long restaurantId) {
        menuService.removeRestaurantFromMenu(menuId, restaurantId);
        return "redirect:/menu/" + menuId;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getMenusByRestaurant(
            @PathVariable Long restaurantId,
            Model model) {
        model.addAttribute("menu",
                menuService.getMenusByRestaurant(restaurantId));
        return "menu/list";
    }

    @GetMapping("/product/{productId}")
    public String getMenusByProduct(
            @PathVariable Long productId,
            Model model) {
        model.addAttribute("menu",
                menuService.getMenusByProduct(productId));
        return "menu/list";
    }
}