package org.example.bestioles.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "species")
public class Espece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "common_name")
    private String nom_commun;
    @Column(name = "latin_name")
    private String nom_latin;
    @OneToMany(mappedBy = "espece")
    private List<Animal> animaux;

    public int getId() {
        return id;
    }

    public String getNom_commun() {
        return nom_commun;
    }

    public void setNom_commun(String nom_commun) {
        this.nom_commun = nom_commun;
    }

    public String getNom_latin() {
        return nom_latin;
    }

    public void setNom_latin(String nom_latin) {
        this.nom_latin = nom_latin;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }
}
