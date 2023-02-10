package org.arosaje.repository;

import org.arosaje.entities.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlantRepository extends CrudRepository<Plant, Integer> {
    void save(Optional<Plant> plant);
}
