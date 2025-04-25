package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.*;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.CartRepository;

import java.util.Date;
import java.util.List;

@Service
public class CartService {
    private CartRepository cartRepository;

    public List<Menu> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void addItem(Long userId, Long productId) {
        cartRepository.addItem(userId, productId);
    }

    public Order placeOrder(Long orderID, Driver driver, Customer customer,
                            Date createdOrderDate, Date finishedOrderDate,
                            DeliveryStatus status, List<Restaurant> restaurants, List<Menu> menu) {
        //double total = menu.stream().mapToDouble(Menu::getPrice).sum();
        Order order = new Order();
        order.setId(orderID);
        order.setCustomer(customer);
        order.setDriver(driver);
        //order.setTotal(total);
        order.setCreatedDate(createdOrderDate);
        order.setFinishedDate(finishedOrderDate);
        order.setStatus(status);
        order.setRestaurants(restaurants);
        return order;
    }
}
