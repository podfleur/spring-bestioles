package org.example.bestioles;

import org.example.bestioles.model.Personne;
import org.example.bestioles.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    @Autowired
    private PersonneRepository personneRepository;

    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DÉMARRAGE TEST DES REPOSITORIES");

        System.out.println("Liste des personnes en base :");
        personneRepository.findAll().forEach(System.out::println);

        Personne newPerson = new Personne();
        newPerson.setPrenom("Alice");
        newPerson.setNom("desmerveilles");
        newPerson.setLogin("Ado");
        newPerson.setMdp("epsiepsi");
        newPerson.setAge(30);
        newPerson.setActive(true);

        personneRepository.save(newPerson);
        System.out.println("Nouvelle personne ajoutée : " + newPerson);

        personneRepository.findAll().forEach(System.out::println);

        personneRepository.deleteById(newPerson.getId());
        System.out.println("Personne supprimée (ID " + newPerson.getId() + ")");

        System.out.println("Liste des personnes après suppression :");
        personneRepository.findAll().forEach(System.out::println);
    }

}
