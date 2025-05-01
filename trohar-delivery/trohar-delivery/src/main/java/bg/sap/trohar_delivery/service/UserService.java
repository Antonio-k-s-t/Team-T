package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.*;
import bg.sap.trohar_delivery.repository.AdminRepository;
import bg.sap.trohar_delivery.repository.CustomerRepository;
import bg.sap.trohar_delivery.repository.DriverRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final CustomerRepository customerRepository;
    private final DriverRepository driverRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(CustomerRepository customerRepository,
                       DriverRepository driverRepository,
                       AdminRepository adminRepository,
                       PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.driverRepository = driverRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        if (user instanceof Customer) {
            customerRepository.save((Customer) user);
        } else if (user instanceof Driver) {
            driverRepository.save((Driver) user);
        } else if (user instanceof Admin) {
            adminRepository.save((Admin) user);

        }else {
            throw new IllegalArgumentException("Unknown user type!");
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<? extends User> user = findUserByUsername(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
    }

    public User getByEmail(String email) {
        Optional<? extends User> user = findUserByEmail(email);
        return user.orElseThrow(() -> new RuntimeException("Email " + email + " not found"));
    }

    private Optional<? extends User> findUserByUsername(String username) {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if (customer.isPresent()) return customer;

        Optional<Driver> driver = driverRepository.findByUsername(username);
        if (driver.isPresent()) return driver;

        return adminRepository.findByUsername(username);
    }

    private Optional<? extends User> findUserByEmail(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) return customer;

        Optional<Driver> driver = driverRepository.findByEmail(email);
        if (driver.isPresent()) return driver;

        return adminRepository.findByEmail(email);
    }

    private Optional<? extends User> findUserByPhone(String phone) {
        Optional<Customer> customer = customerRepository.findByPhone(phone);
        if (customer.isPresent()) return customer;

        Optional<Driver> driver = driverRepository.findByPhone(phone);
        if (driver.isPresent()) return driver;

        return adminRepository.findByPhone(phone);
    }

    public User saveUser(User user) {
        if (user instanceof Customer) {
            return customerRepository.save((Customer) user);
        } else if (user instanceof Driver) {
            return driverRepository.save((Driver) user);
        } else if (user instanceof Admin) {
            return adminRepository.save((Admin) user);
        } else {
            throw new IllegalArgumentException("Unknown user type!");
        }
    }
}
