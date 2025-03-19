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
    private String nomcommun;
    @Column(name = "latin_name")
    private String nomlatin;
    @OneToMany(mappedBy = "espece")
    private List<Animal> animaux;

    public int getId() {
        return id;
    }

    public String getNomcommun() {
        return nomcommun;
    }

    public void setNomcommun(String nomcommun) {
        this.nomcommun = nomcommun;
    }

    public String getNomlatin() {
        return nomlatin;
    }

    public void setNomlatin(String nomlatin) {
        this.nomlatin = this.nomlatin;
    }

    public List<Animal> getAnimaux() {
        return animaux;
    }

    public void setAnimaux(List<Animal> animaux) {
        this.animaux = animaux;
    }

    @Override
    public String toString() {
        return "Espece{" +
                "id=" + id +
                ", nomCommun='" + nomcommun + '\'' +
                ", nomLatin='" + nomlatin + '\'' +
                '}';
    }
}
