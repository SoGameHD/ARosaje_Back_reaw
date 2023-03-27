package org.arosaje.repository;

import org.arosaje.entities.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@Repository
public interface PlantRepository extends CrudRepository<Plant, Integer> {

    @RestResource
    List<Plant> findAllByGuard(@Param("guard") Boolean guard);
}
