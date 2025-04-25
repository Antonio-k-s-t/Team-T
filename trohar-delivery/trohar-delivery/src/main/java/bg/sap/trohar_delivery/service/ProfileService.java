package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import bg.sap.trohar_delivery.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public String getUserRole(String username) {
        Optional<User> user = profileRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getRole();
        } else {
            return "USER NOT FOUND";
        }
    }

    public boolean hasManagerPrivileges(String username) {
        Optional<User> user = profileRepository.findByRole("MANAGER");
        return user.isPresent() && user.get().getUsername().equals(username);
    }
}