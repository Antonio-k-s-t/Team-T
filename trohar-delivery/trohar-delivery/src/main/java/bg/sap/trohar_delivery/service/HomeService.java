package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.HomeRepository;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;

    public List<Home> getHomeItems()
    {
        return homeRepository.findAll();
    }
}