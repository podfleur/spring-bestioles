package org.example.bestioles.repository;

import org.example.bestioles.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    List<Personne> findByNomOrPrenom(String nom, String prenom);

    List<Personne> findByAgeGreaterThanEqual(int age);

}
