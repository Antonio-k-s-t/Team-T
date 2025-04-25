package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import bg.sap.trohar_delivery.repository.CartRepository;
import bg.sap.trohar_delivery.repository.MenuRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Food> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void addItem(Long userId, Long productId) {
        cartRepository.addItem(userId, productId);
    }

    public void placeOrder(Long userId) {
        cartRepository.placeOrder(userId);
    }
}