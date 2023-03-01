package org.arosaje.service;

import org.arosaje.entities.Advice;
import org.arosaje.entities.Plant;
import org.arosaje.entities.User;
import org.arosaje.repository.AdviceRepository;
import org.arosaje.repository.PlantRepository;
import org.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {

    @Autowired
    AdviceRepository adviceRepository;

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    UserRepository userRepository;

    public void storePlantAdvice(Integer plantId, Integer botanistId, Advice advice) {
        Plant plant  = plantRepository.findById( plantId ).orElse(null);
        User user = userRepository.findById(botanistId).orElse(null);
        advice.setPlant(plant);
        advice.setBotanist(user);
        adviceRepository.save(advice);
    }
}
