package com.saatvikpradhan.petstore.repository;

import com.saatvikpradhan.petstore.model.Pet;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {

    private final List<Pet> pets = new ArrayList<>();
    private Long idCounter;

    public PetRepository() {
        // Add some initial pets when the repository is created
        pets.add(new Pet("Fido", "Dog", 30.0, 5, "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*"));
        pets.add(new Pet("Whiskers", "Cat", 15.0, 3, "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg"));
        pets.add(new Pet("Buddy", "Dog", 40.0, 2, "https://www.hartz.com/wp-content/uploads/2022/04/small-dog-owners-1.jpg"));
        pets.add(new Pet("Fluffy", "Cat", 18.0, 4, "https://static01.nyt.com/images/2021/09/14/science/07CAT-STRIPES/07CAT-STRIPES-superJumbo.jpg"));
        pets.add(new Pet("Rocky", "Dog", 25.0, 6, "https://www.nylabone.com/-/media/project/oneweb/nylabone/images/dog101/activities-fun/10-great-small-dog-breeds/maltese-portrait.jpg"));
        idCounter = pets.stream().mapToLong(Pet::getId).max().orElse(0L) + 1;

    }

    public List<Pet> getAllPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pet.setId(idCounter++);
        pets.add(pet);
    }

    public Pet getPetById(Long petId) {
        return pets.stream()
                .filter(pet -> pet.getId().equals(petId))
                .findFirst()
                .orElse(null);
    }

    public void updatePet(Pet updatedPet) {
        pets.stream()
                .filter(pet -> pet.getId().equals(updatedPet.getId()))
                .findFirst()
                .ifPresent(pet -> {
                    pet.setName(updatedPet.getName());
                    pet.setType(updatedPet.getType());
                    pet.setWeight(updatedPet.getWeight());
                    pet.setAge(updatedPet.getAge());
                    pet.setImageUrl(updatedPet.getImageUrl());
                });
    }

    public void removePet(Long petId) {
        pets.removeIf(pet -> pet.getId().equals(petId));
    }
}

