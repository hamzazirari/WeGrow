package com.wegrow.controller;

import com.wegrow.models.Employe;
import com.wegrow.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements/{departementId}/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe ajouter(@PathVariable("departementId") Long departementId,
                           @RequestBody Employe employe) {
        return employeService.ajouter(departementId, employe);
    }

    @GetMapping
    public List<Employe> lister(@PathVariable("departementId") Long departementId) {
        return employeService.listerParDepartement(departementId);
    }
}