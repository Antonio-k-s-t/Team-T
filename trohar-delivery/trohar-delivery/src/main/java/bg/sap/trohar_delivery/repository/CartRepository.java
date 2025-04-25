package bg.sap.trohar_delivery.repository;

import java.util.List;


public interface CartRepository {
    List<Menu> findByUserId(Long userId);
    void addItem(Long userId, Long productId);
    void placeOrder(Long userId);
}
