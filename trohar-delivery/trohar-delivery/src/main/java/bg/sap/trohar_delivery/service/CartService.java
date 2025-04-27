package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Cart;
import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.repository.CartRepository;
import bg.sap.trohar_delivery.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getCartItems(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer id: " + customerId);
        }
        return cart.getProducts();
    }

    public void addItem(Long customerId, Long productId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer id: " + customerId);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        cart.getProducts().add(product);

        if (cart.getTotalPrice() == null) {
            cart.setTotalPrice(0.0);
        }
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());

        cartRepository.save(cart);
    }

    public void removeItem(Long customerId, Long productId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for customer id: " + customerId);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (cart.getProducts().remove(product)) {
            cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
            cartRepository.save(cart);
        }
    }

    public void clearCart(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart != null) {
            cart.getProducts().clear();
            cart.setTotalPrice(0.0);
            cartRepository.save(cart);
        }
    }
}
