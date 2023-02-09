package org.arosaje.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.arosaje.entities.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
}
