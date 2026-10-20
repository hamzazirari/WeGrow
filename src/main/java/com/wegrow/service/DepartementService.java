package com.wegrow.service;

import com.wegrow.models.Departement;
import com.wegrow.models.DepartementResponse;

import java.util.List;

public interface DepartementService {
    Departement creer(Departement departement);
    List<DepartementResponse> lister();
    void supprimer(Long id);
}