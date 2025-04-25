package bg.sap.trohar_delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.sap.trohar_delivery.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

 
}
