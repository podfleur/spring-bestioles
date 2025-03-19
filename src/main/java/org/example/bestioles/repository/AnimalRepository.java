package org.example.bestioles.repository;

import org.example.bestioles.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sexe = :sexe")
    long countBySexe(String sexe);

    List<Animal> findByCouleurIn(List<String> couleurs);
}
