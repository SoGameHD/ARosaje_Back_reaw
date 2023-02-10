package org.arosaje.repository;

import org.arosaje.entities.PlantGuardian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PlantGuardianRepository extends CrudRepository<PlantGuardian, Integer> {

    @RestResource
    List<PlantGuardian> findByPlantId(@Param("id") Integer id );
}