package org.example.jee_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByNomContainingOrPrenomContaining(String nom, String prenom);
    
    List<Employe> findByDepartementId(Long departementId);
    
    @Query("SELECT e FROM Employe e WHERE e.departement.nom = :nomDepartement")
    List<Employe> findByDepartementNom(@Param("nomDepartement") String nomDepartement);
    
    boolean existsByEmail(String email);
} 