package org.example.jee_project.service;

import org.example.jee_project.dao.Departement;
import java.util.List;
import java.util.Optional;

public interface DepartementService {
    List<Departement> getAllDepartements();
    Optional<Departement> getDepartementById(Long id);
    Departement saveDepartement(Departement departement);
    void deleteDepartement(Long id);
    Optional<Departement> findByNom(String nom);
    boolean existsByNom(String nom);
} 