package com.accenture.javajoggers.pets.commando;

import com.accenture.javajoggers.pets.db.AnimalRepository;
import com.accenture.javajoggers.pets.db.AnimalRepositoryException;

import java.util.Scanner;

public class RemoveCommando extends Commando {

    private AnimalRepository animalRepository;
    private Scanner scanner;

    public RemoveCommando(AnimalRepository animalRepository, Scanner scanner) {
        this.animalRepository = animalRepository;
        this.scanner = scanner;
    }

    @Override
    public boolean execute() throws AnimalRepositoryException {
        System.out.println("What pet do you want to remove?");
        String petName = scanner.nextLine();

        System.out.println("Is it a cat or a dog?");
        String animalType = scanner.nextLine();

        animalRepository.removeAnimal(petName, animalType);

        System.out.println("Removed the pet");
        return true;
    }

    @Override
    public boolean shouldExecute(String commandoName) {
        return "remove".equalsIgnoreCase(commandoName);
    }
}
