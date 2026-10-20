package com.wegrow.controller;

import com.wegrow.models.Departement;
import com.wegrow.models.DepartementResponse;
import com.wegrow.service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DepartementResponse> lister() {
        return departementService.lister();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable("id") Long id) {
        departementService.supprimer(id);
    }
}