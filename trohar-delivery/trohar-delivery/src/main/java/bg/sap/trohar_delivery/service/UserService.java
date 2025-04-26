package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Customer;
import bg.sap.trohar_delivery.model.Driver;
import bg.sap.trohar_delivery.model.User;
import bg.sap.trohar_delivery.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User registerUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public List<Customer> getAllCustomers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof Customer)
                .map(user -> (Customer) user)
                .toList();
    }

    public List<Driver> getAllDrivers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof Driver)
                .map(user -> (Driver) user)
                .toList();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email " + email + " not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}