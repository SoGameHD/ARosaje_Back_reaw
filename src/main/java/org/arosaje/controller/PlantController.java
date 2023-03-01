package org.arosaje.controller;

import org.arosaje.entities.Plant;
import org.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PlantController {
    @Autowired
    private PlantService plantService;

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
}
