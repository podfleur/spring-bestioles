package org.example.bestioles.repository;

import org.example.bestioles.model.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspeceRepository extends JpaRepository<Espece, Integer> {
}
