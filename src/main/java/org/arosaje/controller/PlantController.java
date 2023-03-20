package org.arosaje.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.arosaje.entities.Plant;
import org.arosaje.repository.PlantRepository;
import org.arosaje.service.PicturesService;
import org.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class PlantController {
    @Autowired
    private PlantService plantService;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PicturesService pictureService;

    @PostMapping( "/addPlant" )
    public void addPlant(@RequestParam Integer ownerId, @RequestParam(name = "file") MultipartFile file, @RequestParam(name="plant") String plant) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Plant tempPlant = objectMapper.readValue(plant, Plant.class);
        Integer createdPlantId = plantService.storePlant(ownerId,tempPlant);
        pictureService.storePlantPictures(createdPlantId, ownerId, file);
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
