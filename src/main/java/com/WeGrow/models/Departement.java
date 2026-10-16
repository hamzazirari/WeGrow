package com.WeGrow.models;

import org.w3c.dom.Text;

public class Departement {
    private int id;
    private String nom;

    public Departement(int id, String nom, Text description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }

    private Text description;
}
