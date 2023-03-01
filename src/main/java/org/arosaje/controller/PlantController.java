package org.arosaje.controller;

import org.arosaje.entities.Plant;
import org.arosaje.repository.PlantRepository;
import org.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class PlantController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantRepository plantRepository;

    @PostMapping( "/addPlant" )
    public void addPlant(@RequestParam Integer ownerId, @RequestBody Plant plant) {
        plantService.storePlant(ownerId,plant);
    }

    @PostMapping( "/addPlantGuardian" )
    public void addPlantGuardian(@RequestParam Integer guardId, @RequestParam Integer plantId) {
        plantService.setPlantGuardian(guardId,plantId);
    }

    @GetMapping( "/getPlants" )
    public List<Plant> getPlants() {
        return plantService.findAll();
    }

    @GetMapping( "/getPlant/{id}" )
    public Optional<Plant> getPlant(@PathVariable Integer id) {
        return plantRepository.findById(id);
    }
}
