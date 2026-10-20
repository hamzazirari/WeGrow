package com.wegrow.repository;

import com.wegrow.models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    boolean existsByNom(String nom);
}