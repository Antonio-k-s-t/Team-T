package bg.sap.trohar_delivery.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import bg.sap.trohar_delivery.model.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    List<Menu> findByUserId(Long userId);
    public void addItem(Long userId, Long productId);
    public void placeOrder(Long orderID, Driver driver, Customer customer,
                           Date createdOrderDate, Date finishedOrderDate,
                           String status, List<Restaurant> restaurants);

    Optional<Cart> findById(Long cartId);
}
