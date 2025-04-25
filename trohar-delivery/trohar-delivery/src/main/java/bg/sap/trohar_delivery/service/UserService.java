package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Customer;
import bg.sap.trohar_delivery.model.User;
import bg.sap.trohar_delivery.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import bg.sap.trohar_delivery.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public List<Customer> getAllCustomers(){
        return userRepository.findAll().stream().filter(user -> user instanceof Customer)
                .map((user -> (Customer) user).toList();
                .map(user -> (Customer) user)
                .toList();
    }

    public List<Driver> getAllDrivers() {
        return userRepository.findAll().stream()
                .filter(user -> user instanceof Driver)
                .map(user -> (Driver) user)
                .toList();

        public Optional<User> getUserByUsername (String username)
        {
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Username" + username + "not found!"));
        }

        public Optional<User> getByEmail (String email)
        {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new EmailNotFoundException("Email" + email + "not found"));
        }

        public boolean isBlacklisted (User user){
            return user.isBlacklisted();
        }

        public User saveUser (User user){
            return userRepository.save(user);
        }
    }
}