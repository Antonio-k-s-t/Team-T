package bg.sap.trohar_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import bg.sap.trohar_delivery.model.Customer;

@Repository
public interface ProfileRepository extends JpaRepository<Customer, Long>{
    Optional<Customer> findByUsername(String username);
}

