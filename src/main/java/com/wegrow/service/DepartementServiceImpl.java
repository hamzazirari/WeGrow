package com.wegrow.service;

import com.wegrow.exception.ConflitException;
import com.wegrow.exception.ResourceIntrouvableException;
import com.wegrow.models.Departement;
import com.wegrow.models.DepartementResponse;
import com.wegrow.repository.DepartementRepository;
import com.wegrow.repository.EmployeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;
    private final EmployeRepository employeRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository,
                                  EmployeRepository employeRepository) {
        this.departementRepository = departementRepository;
        this.employeRepository = employeRepository;
    }

    @Override
    @Transactional
    public Departement creer(Departement departement) {
        if (departementRepository.existsByNom(departement.getNom())) {
            throw new ConflitException("Le département existe déjà : " + departement.getNom());
        }
        try {
            return departementRepository.saveAndFlush(departement);
        } catch (DataIntegrityViolationException e) {
            throw new ConflitException("Le département existe déjà : " + departement.getNom());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartementResponse> lister() {
        return departementRepository.findAll().stream()
                .map(d -> new DepartementResponse(
                        d.getId(),
                        d.getNom(),
                        d.getDescription(),
                        employeRepository.countByDepartementId(d.getId())))
                .toList();
    }

    @Override
    @Transactional
    public void supprimer(Long id) {
        if (!departementRepository.existsById(id)) {
            throw new ResourceIntrouvableException("Département introuvable : " + id);
        }
        if (employeRepository.countByDepartementId(id) > 0) {
            throw new ConflitException("Ce département contient des employés, suppression impossible");
        }
        departementRepository.deleteById(id);
    }
}