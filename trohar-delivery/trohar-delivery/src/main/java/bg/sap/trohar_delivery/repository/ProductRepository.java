package bg.sap.trohar_delivery.repository;

import bg.sap.trohar_delivery.enums.ProductTypes;
import bg.sap.trohar_delivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByDescriptionContainingIgnoreCase(String description);

    List<Product> findByType(ProductTypes type);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT p FROM Product p JOIN p.menus m WHERE m.id = :menuId")
    List<Product> findByMenuId(Long menuId);

    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.menus LEFT JOIN FETCH p.carts")
    List<Product> findAllWithRelationships();

    List<Product> findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(String name, String description);
}
