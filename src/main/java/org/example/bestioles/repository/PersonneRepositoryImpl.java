package org.example.bestioles.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.example.bestioles.model.Personne;
import org.springframework.stereotype.Repository;

import java.util.Random;
import java.util.UUID;

@Repository
public class PersonneRepositoryImpl implements PersonneRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deletePersonnesWithoutAnimals() {
        entityManager.createQuery("DELETE FROM Personne p WHERE p.animaux IS EMPTY")
                .executeUpdate();
    }

    @Override
    @Transactional
    public void createRandomPersons(int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            Personne personne = new Personne();
            personne.setPrenom("Prénom" + UUID.randomUUID().toString().substring(0, 5));
            personne.setNom("Nom" + UUID.randomUUID().toString().substring(0, 5));
            personne.setLogin("user" + random.nextInt(10000));
            personne.setMdp("pass" + random.nextInt(10000));
            personne.setAge(18 + random.nextInt(50));
            personne.setActive(random.nextBoolean());

            entityManager.persist(personne);
        }

    }
}
