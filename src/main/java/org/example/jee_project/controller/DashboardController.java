package org.example.jee_project.controller;

import org.example.jee_project.service.DepartementService;
import org.example.jee_project.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final EmployeService employeService;
    private final DepartementService departementService;

    @Autowired
    public DashboardController(EmployeService employeService, DepartementService departementService) {
        this.employeService = employeService;
        this.departementService = departementService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalEmployes", employeService.getAllEmployes().size());
        model.addAttribute("totalDepartements", departementService.getAllDepartements().size());
        return "dashboard";
    }
} 