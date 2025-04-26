package bg.sap.trohar_delivery.repository;

import java.util.List;

import bg.sap.trohar_delivery.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByRestaurantsId(Long restaurantId);
    List<Order> findByDriverId(Long driverId);
}
