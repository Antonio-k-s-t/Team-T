package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.enums.Roles;
import bg.sap.trohar_delivery.model.User;
import bg.sap.trohar_delivery.repository.AdminRepository;
import bg.sap.trohar_delivery.repository.CustomerRepository;
import bg.sap.trohar_delivery.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    private final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final AdminRepository adminRepository;

    public ProfileService(CustomerRepository customerRepository, DriverRepository driverRepository, AdminRepository adminRepository) {
        this.customerRepository = customerRepository;
        this.driverRepository = driverRepository;
        this.adminRepository = adminRepository;
    }

    public Roles getUserRole(String username) throws Exception {
        Optional<? extends User> user = findUserByUsername(username);
        if (user.isPresent()) {
            return user.get().getRole();
        } else {
            throw new Exception("Role not found for username: " + username);
        }
    }

    public boolean hasManagerPrivileges(String username) {
        Optional<? extends User> user = findUserByUsername(username);
        return user.isPresent() && user.get().getRole() == Roles.ADMIN; // or whatever your manager role is
    }

    private Optional<? extends User> findUserByUsername(String username) {
        Optional<? extends User> user = customerRepository.findByUsername(username);
        if (user.isPresent()) return user;

        user = driverRepository.findByUsername(username);
        if (user.isPresent()) return user;

        user = adminRepository.findByUsername(username);
        return user;
    }
}
