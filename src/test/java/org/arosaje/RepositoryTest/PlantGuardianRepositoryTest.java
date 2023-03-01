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
        assertNotNull(plantGuardians);
    }

    @Test
    public void testFindById() {
        // Arrangement
        int id = 1;
        // Acting
        PlantGuardian plantGuardianFind = plantGuardianRepository.findById(1).orElse(null);
        // Asserting
        assertNotNull(plantGuardianFind);
        assertEquals(id, plantGuardianFind.getId());
    }
}