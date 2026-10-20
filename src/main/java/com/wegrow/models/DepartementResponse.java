package com.wegrow.models;

public class DepartementResponse {

    private Long id;
    private String nom;
    private String description;
    private long nombreEmployes;

    public DepartementResponse(Long id, String nom, String description, long nombreEmployes) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.nombreEmployes = nombreEmployes;
    }

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public long getNombreEmployes() { return nombreEmployes; }
}