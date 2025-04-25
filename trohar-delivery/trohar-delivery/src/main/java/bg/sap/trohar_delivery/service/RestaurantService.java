package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurantItems()
    {
        return restaurantRepository.findAll();
    }
}