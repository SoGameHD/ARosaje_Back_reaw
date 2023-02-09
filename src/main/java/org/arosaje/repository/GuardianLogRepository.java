package org.arosaje.repository;

import org.arosaje.entities.GuardianLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface GuardianLogRepository extends CrudRepository<GuardianLog, Integer> {

    @RestResource
    List<GuardianLog> findByPlantId(@Param("id") Integer id );
}