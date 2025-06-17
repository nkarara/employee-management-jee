package org.example.jee_project.service;

import org.example.jee_project.dao.Employe;
import java.util.List;
import java.util.Optional;

public interface EmployeService {
    List<Employe> getAllEmployes();
    Optional<Employe> getEmployeById(Long id);
    Employe saveEmploye(Employe employe);
    void deleteEmploye(Long id);
    List<Employe> searchEmployes(String keyword);
    List<Employe> getEmployesByDepartement(Long departementId);
    boolean existsByEmail(String email);
} 