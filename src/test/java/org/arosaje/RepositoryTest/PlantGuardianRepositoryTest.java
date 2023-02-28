package org.arosaje.RepositoryTest;

import org.arosaje.entities.Plant;
import org.arosaje.entities.PlantGuardian;
import org.arosaje.repository.PlantGuardianRepository;
import org.arosaje.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlantGuardianRepositoryTest {

    @Autowired
    private PlantGuardianRepository plantGuardianRepository;

    @Autowired
    private PlantRepository plantRepository;

    private PlantGuardian defaultPlantGuardian = new PlantGuardian(null, null, LocalDate.now(), LocalDate.now());
    @Test
    public void testSaveNotNull() {
        // Arrangement
        PlantGuardian plantGuardian = this.defaultPlantGuardian;

        // Acting
        PlantGuardian savedPlantGuardian = plantGuardianRepository.save(plantGuardian);

        // Asserting
        assertNotNull(savedPlantGuardian);
    }

    @Test
    public void testFindAll() {
        // Arrangement
        List<PlantGuardian> plantGuardians;
        // Acting
        plantGuardians = (List<PlantGuardian>) plantGuardianRepository.findAll();
        // Asserting
        assertEquals(1, plantGuardians.size());
    }

    @Test
    public void testFindById() {
        // Arrangement
        PlantGuardian plantGuardian = new PlantGuardian(1, null, null, this.defaultPlantGuardian.getStart_date(), this.defaultPlantGuardian.getEnd_date());
        // Acting
        PlantGuardian plantGuardianFind = plantGuardianRepository.findById(1).orElseThrow(() -> new RuntimeException("Historique non trouvé"));
        // Asserting
        assertEquals(plantGuardian, plantGuardianFind);
    }

    @Test
    public void testfindByPlantId() {
        // Arrangement
        Plant plant = plantRepository.findById(1).orElseThrow(() -> new RuntimeException("Plante non trouvée"));
        PlantGuardian plantGuardian = new PlantGuardian(null, plant, LocalDate.now(), LocalDate.now());
        // Acting
        plantGuardianRepository.save(plantGuardian);
        List<PlantGuardian> plantGuardianFind = plantGuardianRepository.findByPlantId(1);
        // Asserting
        assertEquals(1, plantGuardianFind.size());
    }
}
