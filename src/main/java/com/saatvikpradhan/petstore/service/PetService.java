package com.saatvikpradhan.petstore.service;
import com.saatvikpradhan.petstore.model.Pet;
import com.saatvikpradhan.petstore.repository.PetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.getAllPets();
    }

    public void addPet(Pet pet) {
        petRepository.addPet(pet);
    }

    public Pet getPetById(Long petId) {
        return petRepository.getPetById(petId);
    }

    public void updatePet(Pet updatedPet) {
        petRepository.updatePet(updatedPet);
    }

    public void removePet(Long petId) {
        petRepository.removePet(petId);
    }

}
