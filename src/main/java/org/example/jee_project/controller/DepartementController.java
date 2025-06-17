package org.example.jee_project.controller;

import org.example.jee_project.dao.Departement;
import org.example.jee_project.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departements")
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public String listDepartements(Model model) {
        model.addAttribute("departements", departementService.getAllDepartements());
        return "departements/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("departement", new Departement());
        return "departements/form";
    }

    @PostMapping
    public String createDepartement(@ModelAttribute Departement departement) {
        departementService.saveDepartement(departement);
        return "redirect:/departements";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        departementService.getDepartementById(id).ifPresent(departement -> 
            model.addAttribute("departement", departement));
        return "departements/form";
    }

    @PostMapping("/{id}")
    public String updateDepartement(@PathVariable Long id, @ModelAttribute Departement departement) {
        departement.setId(id);
        departementService.saveDepartement(departement);
        return "redirect:/departements";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return "redirect:/departements";
    }
} 