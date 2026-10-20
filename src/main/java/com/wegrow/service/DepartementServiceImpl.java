package com.wegrow.service;

import com.wegrow.exception.ConflitException;
import com.wegrow.model.Departement;
import com.wegrow.repository.DepartementRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
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
            // deux requêtes simultanées : la base a refusé le doublon
            throw new ConflitException("Le département existe déjà : " + departement.getNom());
        }
    }
}