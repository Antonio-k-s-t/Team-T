package bg.sap.trohar_delivery.repository;

import bg.sap.trohar_delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    Optional<Restaurant> findByNameIgnoreCase(String name);

    List<Restaurant> findByNameContainingIgnoreCase(String name);

    List<Restaurant> findByAddressContainingIgnoreCase(String address);

    List<Restaurant> findByMenuId(Long menuItemId);

    @Query("SELECT DISTINCT r FROM Restaurant r JOIN r.orders o WHERE o.status = :status")
    List<Restaurant> findByOrderStatus(@Param("status") String status);

    boolean existsByNameIgnoreCase(String name);

    List<Restaurant> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address);
}