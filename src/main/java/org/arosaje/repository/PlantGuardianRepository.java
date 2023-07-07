package org.arosaje.repository;

import org.arosaje.entities.PlantGuardian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RepositoryRestResource(exported = false)
public interface PlantGuardianRepository extends CrudRepository<PlantGuardian, Integer> {

    @RestResource
    List<PlantGuardian> findByPlantId(@Param("id") Integer id );
}