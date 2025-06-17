package org.example.jee_project.service;

import org.example.jee_project.dao.Employe;
import org.example.jee_project.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<Employe> getEmployeById(Long id) {
        return employeRepository.findById(id);
    }

    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public List<Employe> searchEmployes(String keyword) {
        return employeRepository.findByNomContainingOrPrenomContaining(keyword, keyword);
    }

    @Override
    public List<Employe> getEmployesByDepartement(Long departementId) {
        return employeRepository.findByDepartementId(departementId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeRepository.existsByEmail(email);
    }
} 