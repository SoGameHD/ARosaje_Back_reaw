package org.arosaje.service;

import org.arosaje.entities.Plant;
import org.arosaje.entities.PlantGuardian;
import org.arosaje.entities.User;
import org.arosaje.repository.PlantGuardianRepository;
import org.arosaje.repository.PlantRepository;
import org.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantGuardianService {

    @Autowired
    PlantGuardianRepository plantGuardianRepository;

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    UserRepository userRepository;

    public void setGuardPlant(Integer userId, Integer plantId, PlantGuardian plantGuardian) {
        User user = userRepository.findById(userId).orElse(null);
        Plant plant = plantRepository.findById(plantId).orElse(null);
        plantGuardian.setUser(user);
        plantGuardian.setPlant(plant);
        plantGuardianRepository.save(plantGuardian);
    }

}
