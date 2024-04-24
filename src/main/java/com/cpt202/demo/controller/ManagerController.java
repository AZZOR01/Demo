package com.cpt202.demo.controller;

import  com.cpt202.demo.repository.ManagerRepo;
import  com.cpt202.demo.entity.Manager;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

//codeby:Haoyu.li

@Controller
public class ManagerController {

    @Autowired
    private ManagerRepo managerRepo;

    @GetMapping("/manager/show")
    public String getMG(Model model) {
        List<Manager> managers = managerRepo.findAll();
        model.addAttribute("manager", managers);
        return "showManager";// Thymeleaf template name for displaying managers
    }


    @GetMapping("/manager/{id}")
    public String getMGbyID(Long id, Model model) {
        Optional<Manager> manager = managerRepo.findById(id);
        if (manager.isPresent()) {
            model.addAttribute("manager", manager.get());
            return "managerDetails"; // Thymeleaf template name for displaying manager details
        } else {
            return "managerNotFound"; // Thymeleaf template name for manager not found
        }
    }


    @GetMapping("/manager/new")
    public String showCreateManagerForm(Model model) {
        model.addAttribute("manager", new Manager());
        return "addManager"; // Thymeleaf template name for the create manager form
    }

    @PostMapping("/manager/new")
    public String createManager(Manager manager) {
        managerRepo.save(manager);
//        return "redirect:/manager/" + manager.getId(); // Redirect to the manager details page
        return "success";
    }



    @DeleteMapping("/manager/del")
    public String delManager(Long id) {
        managerRepo.deleteById(id);
        return "deleteManager";
    }
}

