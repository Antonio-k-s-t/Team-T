package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Menu;
import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.model.Restaurant;
import bg.sap.trohar_delivery.repository.MenuRepository;
import bg.sap.trohar_delivery.repository.ProductRepository;
import bg.sap.trohar_delivery.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Menu> getAllMenus()
    {
        List<Menu> menus = new ArrayList<>();

        List<Menu> menusWithRestaurants = menuRepository.findAllWithRestaurants();
        menus.addAll(menusWithRestaurants);

        List<Menu> menusWithProducts = menuRepository.findAllWithProducts();
        menus.addAll(menusWithProducts);

        return menus.isEmpty() ? new ArrayList<>() : menus;
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElse(null);
    }

    public List<Menu> getMenusByRestaurant(Long restaurantId) {
        List<Menu> menus = menuRepository.findByRestaurantsId(restaurantId);
        return menus.isEmpty() ? new ArrayList<>() : menus;
    }

    public List<Menu> getMenusByProduct(Long productId) {
        List<Menu> menus = menuRepository.findByProductsId(productId);
        return menus.isEmpty() ? new ArrayList<>() : menus;
    }

    public Menu updateMenuBasicInfo(Long id, Menu menuDetails) {
        Menu menu = menuRepository.findById(id)
                .orElse(null);

        if (menu != null) {
            if (menuDetails.getRestaurants() != null) {
                menu.setRestaurants(menuDetails.getRestaurants());
            }
            if (menuDetails.getProducts() != null) {
                menu.setProducts(menuDetails.getProducts());
            }
            return menuRepository.save(menu);
        }
        return null;
    }

    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElse(null);

        if (menu != null) {
            menu.getRestaurants().forEach(r -> r.setMenu(null));
            menu.getProducts().forEach(p -> p.getMenus().remove(menu));

            menuRepository.delete(menu);
        }
    }

    public Menu addRestaurantToMenu(Long menuId, Long restaurantId) {
        Menu menu = menuRepository.findById(menuId)
                .orElse(null);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElse(null);

        if (menu != null && restaurant != null && !menu.getRestaurants().contains(restaurant)) {
            menu.getRestaurants().add(restaurant);
            restaurant.setMenu(menu);

            return menuRepository.save(menu);
        }
        return null;
    }

    public Menu addProductToMenu(Long menuId, Long productId) {
        Menu menu = menuRepository.findById(menuId)
                .orElse(null);
        Product product = productRepository.findById(productId)
                .orElse(null);

        if (menu != null && product != null && !menu.getProducts().contains(product)) {
            menu.getProducts().add(product);
            product.getMenus().add(menu);

            return menuRepository.save(menu);
        }
        return null;
    }

    public Menu removeRestaurantFromMenu(Long menuId, Long restaurantId) {
        Menu menu = menuRepository.findById(menuId)
                .orElse(null);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElse(null);

        if (menu != null && restaurant != null) {
            menu.getRestaurants().remove(restaurant);
            restaurant.setMenu(null);
            return menuRepository.save(menu);
        }
        return null;
    }

    public Menu removeProductFromMenu(Long menuId, Long productId) {
        Menu menu = menuRepository.findById(menuId)
                .orElse(null);
        Product product = productRepository.findById(productId)
                .orElse(null);

        if (menu != null && product != null) {
            menu.getProducts().remove(product);
            product.getMenus().remove(menu);

            return menuRepository.save(menu);
        }
        return null;
    }
}