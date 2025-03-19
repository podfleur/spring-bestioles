package org.example.bestioles.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "color")
    private String couleur;
    @Column(name = "name")
    private String nom;
    @Column(name = "sex")
    private String sexe;
    @ManyToOne
    @JoinColumn(name = "species_id")
    private Espece espece;
    @ManyToMany(mappedBy = "animaux")
    private List<Personne> personnes;

    public int getId() {
        return id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Espece getEspeces() {
        return espece;
    }

    public void setEspeces(Espece especes) {
        this.espece = especes;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
}
