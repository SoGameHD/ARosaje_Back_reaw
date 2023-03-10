package org.arosaje.controller;

import org.arosaje.entities.PlantGuardian;
import org.arosaje.service.PlantGuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class PlantGuardianController {

    @Autowired
    private PlantGuardianService plantGuardianService;

    @PostMapping( "/addPlantGuard" )
    public void addPlantGuard(@RequestParam Integer userId, @RequestParam Integer plantId, @RequestBody PlantGuardian plantGuardian) throws IOException {
        plantGuardianService.setGuardPlant(userId, plantId,plantGuardian);
    }
}
