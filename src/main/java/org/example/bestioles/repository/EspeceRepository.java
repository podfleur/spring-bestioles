package org.example.bestioles.repository;

import org.example.bestioles.model.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EspeceRepository extends JpaRepository<Espece, Integer> {

    Optional<Espece> findFirstByNomcommun(String nomcommun);

    List<Espece> findByNomlatinIsContainingIgnoreCase(String nomlatinPartiel);
}
