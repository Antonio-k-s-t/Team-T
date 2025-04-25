package bg.sap.trohar_delivery.repository;

import java.util.List;
import bg.sap.trohar_delivery.model.Order;

public interface CartRepository {
    List<Menu> findByUserId(Long userId);
    void addItem(Long userId, Long productId);
    void placeOrder(Long orderID, Driver driver, Customer customer,
                    Date createdOrderDate, Date finishedOrderDate,
                    String status, List<Restaurant> restaurants);
}
