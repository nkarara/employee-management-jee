package org.example.jee_project.service;

import org.example.jee_project.dao.Utilisateur;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Optional<Utilisateur> findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteUtilisateur(Long id);
} 