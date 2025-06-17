package org.example.jee_project.controller;

import org.example.jee_project.dao.Employe;
import org.example.jee_project.service.DepartementService;
import org.example.jee_project.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;
    private final DepartementService departementService;

    @Autowired
    public EmployeController(EmployeService employeService, DepartementService departementService) {
        this.employeService = employeService;
        this.departementService = departementService;
    }

    @GetMapping
    public String listEmployes(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("employes", employeService.searchEmployes(keyword));
        } else {
            model.addAttribute("employes", employeService.getAllEmployes());
        }
        return "employes/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employe", new Employe());
        model.addAttribute("departements", departementService.getAllDepartements());
        return "employes/form";
    }

    @PostMapping
    public String createEmploye(@ModelAttribute Employe employe) {
        employeService.saveEmploye(employe);
        return "redirect:/employes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        employeService.getEmployeById(id).ifPresent(employe -> {
            model.addAttribute("employe", employe);
            model.addAttribute("departements", departementService.getAllDepartements());
        });
        return "employes/form";
    }

    @PostMapping("/{id}")
    public String updateEmploye(@PathVariable Long id, @ModelAttribute Employe employe) {
        employe.setId(id);
        employeService.saveEmploye(employe);
        return "redirect:/employes";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
        return "redirect:/employes";
    }

    @GetMapping("/departement/{departementId}")
    public String listEmployesByDepartement(@PathVariable Long departementId, Model model) {
        model.addAttribute("employes", employeService.getEmployesByDepartement(departementId));
        return "employes/list";
    }
} 