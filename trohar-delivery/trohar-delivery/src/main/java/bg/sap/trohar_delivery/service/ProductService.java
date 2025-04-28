package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.enums.ProductTypes;
import bg.sap.trohar_delivery.model.Cart;
import bg.sap.trohar_delivery.model.Menu;
import bg.sap.trohar_delivery.model.Product;
import bg.sap.trohar_delivery.repository.CartRepository;
import bg.sap.trohar_delivery.repository.MenuRepository;
import bg.sap.trohar_delivery.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final MenuRepository menuRepository;
    private final CartRepository cartRepository;

    public ProductService(ProductRepository productRepository,
                          MenuRepository menuRepository,
                          CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.menuRepository = menuRepository;
        this.cartRepository = cartRepository;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllWithRelationships();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> searchProducts(String name, String description, ProductTypes type,
                                        Double minPrice, Double maxPrice) {
        if (name != null && description != null) {
            return productRepository.findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(name, description);
        } else if (name != null) {
            return productRepository.findByNameContainingIgnoreCase(name);
        } else if (description != null) {
            return productRepository.findByDescriptionContainingIgnoreCase(description);
        } else if (type != null) {
            return productRepository.findByType(type);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice);
        }
        return productRepository.findAll();
    }

    public void updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        if (productDetails.getName() != null) {
            product.setName(productDetails.getName());
        }
        if (productDetails.getDescription() != null) {
            product.setDescription(productDetails.getDescription());
        }
        if (productDetails.getType() != null) {
            product.setType(productDetails.getType());
        }
        if (productDetails.getPrice() != null) {
            product.setPrice(productDetails.getPrice());
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Clear relationships before deletion
        product.getMenus().forEach(m -> m.getProducts().remove(product));
        product.getCarts().forEach(c -> c.getProducts().remove(product));

        productRepository.delete(product);
    }

    public void addMenuToProduct(Long productId, Long menuId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        if (!product.getMenus().contains(menu)) {
            product.getMenus().add(menu);
            menu.getProducts().add(product);
        }

        productRepository.save(product);
    }

    public void removeMenuFromProduct(Long productId, Long menuId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        product.getMenus().remove(menu);
        menu.getProducts().remove(product);

        productRepository.save(product);
    }

    public Product removeCartFromProduct(Long productId, Long cartId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));

        product.getCarts().remove(cart);
        cart.getProducts().remove(product);

        return productRepository.save(product);
    }

    public List<Product> getProductsByMenu(Long menuId) {
        return productRepository.findByMenuId(menuId);
    }

}
