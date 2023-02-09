package org.arosaje.service;

import org.arosaje.entities.Plant;
import org.arosaje.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public Iterable<Plant> getPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> getPlantById(Integer id) {
        return plantRepository.findById(id);
    }

    public void createPlant(Plant plant) {
        plantRepository.save(plant);
    }

    public void savePlant(Plant plant) {
        plantRepository.save(plant);
    }
    public void deletePlantById(Integer id) {
        plantRepository.deleteById(id);
    }
}
