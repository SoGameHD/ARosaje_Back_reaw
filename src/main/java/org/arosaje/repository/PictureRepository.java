package org.arosaje.repository;

import org.arosaje.entities.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Set;

public interface PictureRepository extends CrudRepository<Picture, Integer> {
    @RestResource
     List<Picture> getAllByPlantId(@Param("id") Integer id);



}