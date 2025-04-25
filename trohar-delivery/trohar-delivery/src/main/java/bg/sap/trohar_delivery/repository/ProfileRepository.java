package bg.sap.trohar_delivery.repository;

import bg.sap.trohar_delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProfileRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Optional<User> findByRole(String userRole);
}

