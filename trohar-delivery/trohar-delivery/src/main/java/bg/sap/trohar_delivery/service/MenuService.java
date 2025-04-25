package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Menu;
import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.model.Restaurant;
import bg.sap.trohar_delivery.repository.MenuRepository;
import bg.sap.trohar_delivery.repository.ProductRepository;
import bg.sap.trohar_delivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;

    public MenuService(MenuRepository menuRepository,
                       RestaurantRepository restaurantRepository,
                       ProductRepository productRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.productRepository = productRepository;
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAllWithRelationships();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));
    }

    public List<Menu> getMenusByRestaurant(Long restaurantId) {
        return menuRepository.findByRestaurantsId(restaurantId);
    }

    public List<Menu> getMenusByProduct(Long productId) {
        return menuRepository.findByProductsId(productId);
    }

    public Menu updateMenuBasicInfo(Long id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));

        // Note: Since Menu entity currently has no basic fields to update,
        // this method is prepared for future fields
        return menuRepository.save(menu);
    }

    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + id));

        // Clear relationships before deletion
        menu.getRestaurants().forEach(r -> r.setMenu(null));
        menu.getProducts().forEach(p -> p.getMenus().remove(menu));

        menuRepository.delete(menu);
    }

    public Menu addRestaurantToMenu(Long menuId, Long restaurantId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

        if (!menu.getRestaurants().contains(restaurant)) {
            menu.getRestaurants().add(restaurant);
            restaurant.setMenu(menu);
        }

        return menuRepository.save(menu);
    }

    public Menu addProductToMenu(Long menuId, Long productId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (!menu.getProducts().contains(product)) {
            menu.getProducts().add(product);
            product.getMenus().add(menu);
        }

        return menuRepository.save(menu);
    }

    public Menu removeRestaurantFromMenu(Long menuId, Long restaurantId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

        menu.getRestaurants().remove(restaurant);
        restaurant.setMenu(null);

        return menuRepository.save(menu);
    }

    public Menu removeProductFromMenu(Long menuId, Long productId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        menu.getProducts().remove(product);
        product.getMenus().remove(menu);

        return menuRepository.save(menu);
    }
}