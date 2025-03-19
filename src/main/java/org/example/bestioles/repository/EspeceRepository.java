package org.example.bestioles.repository;

import org.example.bestioles.model.Espece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspeceRepository extends JpaRepository<Espece, Integer> {

    Optional<Espece> findFirstByNomcommun(String nomcommun);

    List<Espece> findByNomlatinIsContainingIgnoreCase(String nomlatinPartiel);

    @Query("SELECT e FROM Espece e ORDER BY e.nomcommun ASC")
    List<Espece> findAllOrderedByNomcommunAsc();

    @Query("SELECT e FROM Espece e WHERE e.nomcommun LIKE %:nomcommun%")
    List<Espece> findByNomcommunLike(@Param("nomcommun") String nomcommun);
}
