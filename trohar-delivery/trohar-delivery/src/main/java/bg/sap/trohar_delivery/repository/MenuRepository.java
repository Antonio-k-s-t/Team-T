package bg.sap.trohar_delivery.repository;

import java.util.List;

import bg.sap.trohar_delivery.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long>{
    List<Menu> findByRestaurantsId(Long restaurantId);

    List<Menu> findByProductsId(Long productId);

    @Query("SELECT DISTINCT m FROM Menu m LEFT JOIN FETCH m.restaurants LEFT JOIN FETCH m.products")
    List<Menu> findAllWithRelationships();
}
