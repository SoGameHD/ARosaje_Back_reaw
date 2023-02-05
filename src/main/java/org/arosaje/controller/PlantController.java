package org.arosaje.controller;

import org.arosaje.dto.PlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PlantController {

    @Autowired
    private org.arosaje.repository.PlantRepositoryImpl PlantRepositoryImpl;

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getPlants")
    public List<PlantDTO> getPlants() {
        return PlantRepositoryImpl.getPlants();
    }

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getPlantById")
    public Object getPlantById(@RequestParam(name="id") long id) {
        return PlantRepositoryImpl.getPlantById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/v1/getPlantsByOwnerId")
    public List<PlantDTO> getPlantsByOwnerId(@RequestParam(name="id") long id) {
        return PlantRepositoryImpl.getPlantsByOwnerId(id);
    }
}
