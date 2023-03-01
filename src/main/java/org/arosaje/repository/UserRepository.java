package org.arosaje.repository;

import org.arosaje.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

    @RestResource
    User findByEmail(@Param("email") String email);
}
