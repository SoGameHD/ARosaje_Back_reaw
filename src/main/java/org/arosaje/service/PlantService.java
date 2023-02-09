package org.arosaje.service;

import org.arosaje.entities.Plant;
import org.arosaje.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlantService {
    @Autowired
    PlantRepository dao;

    public Iterable<Plant> getPlants() {
        return dao.findAll();
    }

    public Optional<Plant> getPlantById(Integer id) {
        return dao.findById(id);
    }

    public void createPlant(Plant plant) {
        dao.save(plant);
    }

    public void savePlant(Plant plant) {
        dao.save(plant);
    }
    public void deletePlantById(Integer id) {
        dao.deleteById(id);
    }
}
