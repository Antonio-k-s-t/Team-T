package bg.sap.trohar_delivery.service;

import bg.sap.trohar_delivery.model.Roles;
import bg.sap.trohar_delivery.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import bg.sap.trohar_delivery.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Roles getUserRole(String username) throws Exception {
        Optional<User> user = profileRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getRole();
        } else {
            throw new Exception("Role not found");
        }
    }

    public boolean hasManagerPrivileges(String username) {
        Optional<User> user = profileRepository.findByRole("MANAGER");
        return user.isPresent() && user.get().getUsername().equals(username);
    }
}