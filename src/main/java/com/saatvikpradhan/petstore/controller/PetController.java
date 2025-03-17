package com.saatvikpradhan.petstore.controller;
import com.saatvikpradhan.petstore.model.Pet;
import com.saatvikpradhan.petstore.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.nio.file.Paths;


@Controller
public class PetController {
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "home";
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message) {
        try {
            String basePath = Paths.get("").toAbsolutePath().toString();
            String filePath = basePath + "/src/main/resources/static/contact-submissions.csv";
            try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
                writer.println(name + "," + email + "," + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "about";
    }


    @GetMapping("/pets/add")
    public String addPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "addPet";
    }

    @PostMapping("/pets/add")
    public String addPet(@ModelAttribute Pet pet) {
        petService.addPet(pet);
        return "redirect:/";
    }

    @GetMapping("/pets/edit/{petId}")
    public String editPetForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        if (pet != null) {
            model.addAttribute("pet", pet);
            return "editPet";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/pets/edit/{petId}")
    public String editPet(@PathVariable Long petId, @ModelAttribute Pet updatedPet) {
        updatedPet.setId(petId);
        petService.updatePet(updatedPet);
        return "redirect:/";
    }

    @GetMapping("/pets/remove/{petId}")
    public String removePet(@PathVariable Long petId) {
        petService.removePet(petId);
        return "redirect:/";
    }

    @GetMapping("/pets")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
