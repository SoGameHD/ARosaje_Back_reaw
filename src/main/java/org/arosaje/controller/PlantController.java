package org.arosaje.controller;

import org.arosaje.entities.Plant;
import org.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlantController {

    @Autowired
    private PlantService plantService;

    @RequestMapping(method = RequestMethod.GET, value ="/getPlants")
    public Iterable<Plant> getPlants() {
        return plantService.getPlants();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/getPlantById")
    public Optional<Plant> getPlantById(@RequestParam(name = "id") Integer id) {
        System.out.println(plantService.getPlantById(id));
        return plantService.getPlantById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createPlant")
    public void createPlant(@RequestParam(name = "plant") Plant plant) {
        plantService.createPlant(plant);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatePlant")
    public void updatePlant(@RequestParam(name = "plant") Plant plant) {
        plantService.savePlant(plant);
    }
    @RequestMapping(method = RequestMethod.DELETE, value ="/deletePlantById")
    public void deletePlantById(@RequestParam(name = "id") Integer id) {
        plantService.deletePlantById(id);
    }

}
