package com.wegrow.service;

import com.wegrow.exception.ConflitException;
import com.wegrow.exception.ResourceIntrouvableException;
import com.wegrow.models.Employe;
import com.wegrow.repository.DepartementRepository;
import com.wegrow.repository.EmployeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private final DepartementRepository departementRepository;

    public EmployeServiceImpl(EmployeRepository employeRepository,
                              DepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.departementRepository = departementRepository;
    }

    @Override
    @Transactional
    public Employe ajouter(Long departementId, Employe employe) {
        if (!departementRepository.existsById(departementId)) {
            throw new ResourceIntrouvableException("Département introuvable : " + departementId);
        }
        if (employeRepository.existsByMatricule(employe.getMatricule())) {
            throw new ConflitException("Matricule déjà utilisé : " + employe.getMatricule());
        }
        employe.setDepartementId(departementId);
        try {
            return employeRepository.saveAndFlush(employe);
        } catch (DataIntegrityViolationException e) {
            throw new ConflitException("Matricule déjà utilisé : " + employe.getMatricule());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> listerParDepartement(Long departementId) {
        if (!departementRepository.existsById(departementId)) {
            throw new ResourceIntrouvableException("Département introuvable : " + departementId);
        }
        return employeRepository.findByDepartementId(departementId);
    }
}