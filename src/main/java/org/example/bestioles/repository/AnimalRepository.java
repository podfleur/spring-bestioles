package org.example.bestioles.repository;


import org.example.bestioles.model.Animal;
import org.example.bestioles.model.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    //List<Animal> findAnimalByEspece(int espece_id);

    List<Animal> findByCouleurIn(List<String> couleurs);

}
