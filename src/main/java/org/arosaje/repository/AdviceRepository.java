package org.arosaje.repository;

import org.arosaje.entities.Advice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public interface AdviceRepository extends CrudRepository<Advice, Integer> { }
