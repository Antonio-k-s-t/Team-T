package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.enums.Roles;
import bg.sap.trohar_delivery.model.*;
import bg.sap.trohar_delivery.repository.AdminRepository;
import bg.sap.trohar_delivery.repository.CustomerRepository;
import bg.sap.trohar_delivery.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

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

    @Transactional
    public void registerUser(String fullname, String newUsername, String newPassword, String role) {
        switch (role) {
            case "CUSTOMER":
                Customer customer = new Customer();
                customer.setName(fullname);
                customer.setUsername(newUsername);
                customer.setPassword(passwordEncoder.encode(newPassword));
                customer.setRole(Roles.CUSTOMER);
                customerRepository.save(customer);
                break;
            case "ADMIN":
                Admin admin = new Admin();
                admin.setName(fullname);
                admin.setUsername(newUsername);
                admin.setPassword(passwordEncoder.encode(newPassword));
                admin.setRole(Roles.ADMIN);
                adminRepository.save(admin);
                break;
            case "DRIVER":
                Driver driver = new Driver();
                driver.setName(fullname);
                driver.setUsername(newUsername);
                driver.setPassword(passwordEncoder.encode(newPassword));
                driver.setRole(Roles.DRIVER);
                driverRepository.save(driver);
                break;
            default:
                throw new IllegalArgumentException("No such role: " + role);
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

    public Optional<? extends User> findUserByUsername(String username) {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        System.out.println("Found user with role: " + user.getRole());
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
