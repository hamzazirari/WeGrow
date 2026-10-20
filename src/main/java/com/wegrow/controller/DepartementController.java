package com.wegrow.controller;

import com.wegrow.model.Departement;
import com.wegrow.service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departement creer(@RequestBody Departement departement) {
        return departementService.creer(departement);
    }
}