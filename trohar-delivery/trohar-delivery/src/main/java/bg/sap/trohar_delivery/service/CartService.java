package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import bg.sap.trohar_delivery.repository.CartRepository;
import bg.sap.trohar_delivery.repository.MenuRepository;
import bg.sap.trohar_delivery.model.Order;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Menu> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void addItem(Long userId, Long productId) {
        cartRepository.addItem(userId, productId);
    }

    public Order placeOrder(Long orderID, Driver driver, Customer customer,
                           Date createdOrderDate, Date finishedOrderDate,
                           String status, List<Menu> menu) {
        double total = menu.stream().mapToDouble(Menu::getPrice).sum();
        Oder order = new Order();
        order.setId(orderID);
        order.setCustomer(customer);
        order.setDriver(driver);
        order.setTotal(total);
        order.setCreatedDate(createdOrderDate);
        order.setFinishedDate(finishedOrderDate);
        order.setStatus(status);
        order.setRestaurants(restaurants);

}
