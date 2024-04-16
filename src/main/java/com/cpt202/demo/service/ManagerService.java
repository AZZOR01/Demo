package com.cpt202.demo.service;

import com.cpt202.demo.entity.Manager;
import com.cpt202.demo.repository.ManagerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepo managerRepository;

    @Autowired
    public ManagerService(ManagerRepo managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }
    
    public Optional<Manager> getManagerById(int id) {
        return managerRepository.findById(id);
    }

    public Manager createManager(Manager manager) {  
        return managerRepository.save(manager);
    }
    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }
    // public Manager updateManager(int id, Manager updatedManager) {
    //     // Implement update logic (e.g., update fields)
    //     Optional<Manager> existingManager = managerRepository.findById(id);
    //     if (existingManager.isEmpty()) {
    //         throw new EntityNotFoundException("Manager with ID " + id + " not found.");
    //     }

    //     Manager managerToUpdate = existingManager.get();

    //     // Update specific fields (e.g., username, email)
    //     if (updatedManager.getUsername() != null) {
    //         managerToUpdate.setUsername(updatedManager.getUsername());
    //     }
    //     if (updatedManager.getEmail() != null) {
    //         managerToUpdate.setEmail(updatedManager.getEmail());
    //     }

    //     // You can add more update logic here based on your requirements

    //     return managerRepository.save(managerToUpdate);
    //     // ...
    // }
}

