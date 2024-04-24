package com.cpt202.demo.service;

import  com.cpt202.demo.entity.Manager;
import com.cpt202.demo.repository.ManagerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ManagerService {
    @Autowired
    private final ManagerRepo managerRepo;
    @Autowired
    public ManagerService(ManagerRepo managerRepo){
        this.managerRepo = managerRepo;
    }

    public List<Manager> getAllMananger(){
        return managerRepo.findAll();
    }

    public Optional<Manager> getmanagerById(Long id) {
        return managerRepo.findById(id);
    }

    public Manager createManager(Manager manager){
        return managerRepo.save(manager);
    }

    public Manager updateManager(Long id, Manager updatedManager) {
        // Implement update logic
        Optional<Manager> existingManager = managerRepo.findById(id);
        if (existingManager.isEmpty()) {
            throw new EntityNotFoundException("Manager with ID " + id + " not found.");
        }

        Manager managerToUpdate = existingManager.get();
        // Update specific fields
        if (updatedManager.getUsername() != null) {
            managerToUpdate.setUsername(updatedManager.getUsername());
        }
        if (updatedManager.getPassword() != null) {
            managerToUpdate.setPassword(updatedManager.getPassword());
        }
        if (updatedManager.getPhone() != null) {
            managerToUpdate.setPassword(updatedManager.getPhone());
        }


        return managerRepo.save(managerToUpdate);
        // ...
    }

    public void deleteManager(Long id) {
        managerRepo.deleteById(id);
    }
}
