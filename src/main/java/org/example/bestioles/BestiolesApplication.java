package org.example.bestioles;

import jakarta.transaction.Transactional;
import org.example.bestioles.model.*;
import org.example.bestioles.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private EspeceRepository especeRepository;
    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("DÉBUT TP");

        System.out.println("Liste des personnes en base :");
        personneRepository.findAll().forEach(System.out::println);

        Personne personWithoutAnimal = new Personne();
        personWithoutAnimal.setPrenom("Jean");
        personWithoutAnimal.setNom("Dupont");
        personWithoutAnimal.setLogin("jean");
        personWithoutAnimal.setMdp("password");
        personWithoutAnimal.setAge(40);
        personWithoutAnimal.setActive(true);

        personneRepository.save(personWithoutAnimal);
        System.out.println("Nouvelle personne ajoutée sans animal : " + personWithoutAnimal);

        Personne personWithAnimal = new Personne();
        personWithAnimal.setPrenom("Emma");
        personWithAnimal.setNom("Durand");
        personWithAnimal.setLogin("emmad");
        personWithAnimal.setMdp("securepwd");
        personWithAnimal.setAge(28);
        personWithAnimal.setActive(true);

        personneRepository.save(personWithAnimal);

        Animal animal = new Animal();
        animal.setNom("Rex");
        animal.setSexe("Mâle");
        animal.setCouleur("Noir");

        animalRepository.save(animal);
        System.out.println("Nouvelle personne avec animal ajoutée : " + personWithAnimal);
        System.out.println("Animal ajouté : " + animal);

        System.out.println("Liste des personnes AVANT suppression des personnes sans animaux :");
        personneRepository.findAll().forEach(System.out::println);

        System.out.println("Suppression des personnes sans animaux...");
        personneRepository.deletePersonnesWithoutAnimals();

        System.out.println("Liste des personnes APRES suppression des personnes sans animaux :");
        personneRepository.findAll().forEach(System.out::println);

        System.out.println("Ajout de 5 personnes aléatoires...");
        personneRepository.createRandomPersons(5);

        System.out.println("Liste des personnes après insertion :");
        personneRepository.findAll().forEach(System.out::println);

        System.out.println("FIN TP");
    }
}
