package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Menu;
import bg.sap.trohar_delivery.model.Restaurant;
import bg.sap.trohar_delivery.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant) throws Exception {
        if (restaurantRepository.existsByNameIgnoreCase(restaurant.getName())) {
            throw new Exception("Restaurant with name '" + restaurant.getName() + "' already exists");
        }

        // Ensure menu is saved first if it's new
        if (restaurant.getMenu() != null && restaurant.getMenu().getId() == null) {
            Menu savedMenu = menuRepository.save(restaurant.getMenu());
            restaurant.setMenu(savedMenu);
        }

        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new Exception("Restaurant not found with id: " + id));

        // Check if name is being changed to one that already exists
        if (!restaurant.getName().equalsIgnoreCase(restaurantDetails.getName()) &&
                restaurantRepository.existsByNameIgnoreCase(restaurantDetails.getName())) {
            throw new Exception("Restaurant with name '" + restaurantDetails.getName() + "' already exists");
        }

        restaurant.setName(restaurantDetails.getName());
        restaurant.setAddress(restaurantDetails.getAddress());

        // Handle menu update
        if (restaurantDetails.getMenu() != null) {
            if (restaurant.getMenu() == null) {
                // If no existing menu, save the new one
                Menu savedMenu = menuRepository.save(restaurantDetails.getMenu());
                restaurant.setMenu(savedMenu);
            } else {
                // Update existing menu
                menuRepository.save(restaurant.getMenu());
            }
        }

        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant getRestaurantById(Long id) throws Exception {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new Exception("Restaurant not found with id: " + id));
    }

    @Transactional
    public List<Restaurant> searchRestaurants(String name, String address) {
        if (name != null && address != null) {
            return restaurantRepository.findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(name, address);
        } else if (name != null) {
            return restaurantRepository.findByNameContainingIgnoreCase(name);
        } else if (address != null) {
            return restaurantRepository.findByAddressContainingIgnoreCase(address);
        }
        return restaurantRepository.findAll();
    }

    @Transactional
    public void deleteRestaurant(Long id) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new Exception("Restaurant not found with id: " + id));

        // Check if restaurant has active orders
        if (!restaurant.getOrders().isEmpty()) {
            throw new Exception("Cannot delete restaurant with active orders");
        }

        restaurantRepository.delete(restaurant);
    }

    @Transactional
    public List<Restaurant> getRestaurantsByMenuItem(Long menuId) {
        return restaurantRepository.findByMenuId(menuId);
    }

    @Transactional
    public List<Restaurant> getRestaurantsByOrderStatus(String status) {
        return restaurantRepository.findByOrderStatus(status);
    }

}
