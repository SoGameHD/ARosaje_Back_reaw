package org.arosaje.repository;

import org.arosaje.entities.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PlantRepository extends CrudRepository<Plant, Integer> {

    @RestResource
    List<Plant> getAllByGuardIsFalse();
}
