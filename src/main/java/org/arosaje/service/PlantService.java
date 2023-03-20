package org.arosaje.service;

import org.arosaje.entities.Plant;
import org.arosaje.entities.User;
import org.arosaje.repository.PlantRepository;
import org.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    UserRepository userRepository;

    public Integer storePlant(Integer ownerId, Plant plant) {
        User owner = userRepository.findById(ownerId).orElse(null);
        plant.setOwner_user(owner);
        Plant plantCreated = plantRepository.save(plant);
        return plantCreated.getId();
    }

    public void setPlantGuardian(Integer guardId, Integer plantId) {
        User guard = userRepository.findById(guardId).orElse(null);
        Plant plant = plantRepository.findById(plantId).orElse(null);
        plant.setGuardian_user(guard);
        plant.setGuard(true);
        plantRepository.save(plant);
    }

    public List<Plant> findAll() {
        return (List<Plant>) plantRepository.findAll();
    }
}
