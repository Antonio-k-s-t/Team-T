package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant Res(Long ID, String name, String address, Menu menu, List<Order> products)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(ID);
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setMenu(menu);
        restaurant.setOrders(products);

        return restaurantRepository.save(restaurant);
    }
}
