package com.wegrow.service;

import com.wegrow.models.Employe;

import java.util.List;

public interface EmployeService {
    Employe ajouter(Long departementId, Employe employe);
    List<Employe> listerParDepartement(Long departementId);
}