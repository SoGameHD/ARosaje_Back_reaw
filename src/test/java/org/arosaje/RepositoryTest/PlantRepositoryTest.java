package org.arosaje.RepositoryTest;

import org.arosaje.entities.Plant;
import org.arosaje.repository.PlantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository repository;

    private Plant defaultPlant = new Plant("Cactus", LocalDateTime.now(), LocalDate.now(), LocalDate.now(), false, null, null);
    @Test
    public void testSaveNotNull() {
        // Arrangement
        Plant plant = this.defaultPlant;

        // Acting
        Plant savedPlant = repository.save(plant);

        // Asserting
        assertNotNull(savedPlant);
    }

    @Test
    public void testFindAll() {
        // Arrangement
        List<Plant> plants;
        // Acting
        plants = (List<Plant>) repository.findAll();
        // Asserting
        assertNotNull(plants);
    }

    @Test
    public void testFindById() {
        // Arrangement
        int id = 1;
        // Acting
        Plant plantFind = repository.findById(1).orElseThrow(() -> new RuntimeException("Plantes non trouvée"));
        // Asserting
        assertEquals(id, plantFind.getId());
    }
}
