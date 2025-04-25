package bg.sap.trohar_delivery.repository;

import java.util.List;

import bg.sap.trohar_delivery.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{
    List<Menu> findByItemNameIgnoreCase(String itemName);

    List<Menu> findByItemNameContainingIgnoreCase(String itemName);

    List<Menu> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT m FROM Menu m JOIN m.restaurants r WHERE r.id = :restaurantId")
    List<Menu> findByRestaurantId(@Param("restaurantId") Long restaurantId);

    List<Menu> findByItemDescriptionContainingIgnoreCase(String description);

    boolean existsByItemNameIgnoreCaseAndPrice(String itemName, Double price);
}
