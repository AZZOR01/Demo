package com.cpt202.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt202.demo.entity.monthlyMembers;
import com.cpt202.demo.repository.ReportRepo;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class reportcontroller {
    @Autowired
   private final ReportRepo ReportRepo;

   
   public reportcontroller(ReportRepo ReportRepo){
    this.ReportRepo= ReportRepo;
    }

 @GetMapping("/api/report/monthlyMembers")
public List<monthlyMembers> getAllMemberes() {
    return ReportRepo.findAll();
}


    @GetMapping("/api/hi")
    public String getMonthlyReport(Model m) {
        m.addAttribute("data", "momo");
        return "momo";
    }

}