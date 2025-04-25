package bg.sap.trohar_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import bg.sap.trohar_delivery.model.User;

@Repository
public interface ProfileRepository extends JpaRepository<User, Long>{
    Optional<User> findByRoleAndUsername(String role, String username);
}

