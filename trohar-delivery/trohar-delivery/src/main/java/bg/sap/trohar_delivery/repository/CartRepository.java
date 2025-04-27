package bg.sap.trohar_delivery.repository;

import bg.sap.trohar_delivery.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByCustomerId(Long customerId);
}
