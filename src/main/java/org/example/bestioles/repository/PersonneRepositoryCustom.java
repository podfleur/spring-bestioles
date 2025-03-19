package org.example.bestioles.repository;

public interface PersonneRepositoryCustom {
    void deletePersonnesWithoutAnimals();
    void createRandomPersons(int number);
}
