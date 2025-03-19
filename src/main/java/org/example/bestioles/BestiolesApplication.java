package org.example.bestioles;

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
    public void run(String... args) throws Exception {
        System.out.println("DÉBUT TP03");

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

        System.out.println("FIN TP03");
        System.out.println("DÉBUT TP04");

        Optional<Espece> espece1 = especeRepository.findFirstByNomcommun("Chat");
        espece1.ifPresent(E -> System.out.println("Espèce trouvée : " + E.getNomcommun()));

        List<Espece> espece2 = especeRepository.findByNomlatinIsContainingIgnoreCase("Canis");
        System.out.println("Espèces trouvées : " + espece2);

        List<Personne> personnes1 = personneRepository.findByNomOrPrenom("Nero", "Bill");
        System.out.println("Personnes ou nom demandé: " + personnes1);

        List<Personne> personnes2 = personneRepository.findByAgeGreaterThanEqual(33);
        System.out.println("Personnes de 33 ans ou plus : " + personnes2);

        // Espece espece = especeRepository.findById(1).orElseThrow();
        // List<Animal> animal1 = animalRepository.findAnimalByEspece(1);
        // System.out.println("Animaux par espèce : " + animal1);

        List<String> couleurs = List.of("Noir", "Blanc", "Brun");
        List<Animal> animal2 = animalRepository.findByCouleurIn(couleurs);
        System.out.println("Animaux par liste de couleur : " + animal2);

        long countMales = animalRepository.countBySexe("Mâle");
        long countFemelles = animalRepository.countBySexe("Femelle");
        System.out.println("Nombre d'animaux mâles : " + countMales);
        System.out.println("Nombre d'animaux femelles : " + countFemelles);
    }
}
