package org.arosaje.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.arosaje.dto.PlantDTO;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;

    public List<PlantDTO> getPlants() {
        String request = "SELECT id, nom, proprio_id, date_ajout, date_dernier_entretien FROM plantes";

        Query query = entityManager.createNativeQuery(request);
        return query.getResultList();
    }

    public Object getPlantById(long id) {
        String request = "SELECT id, nom, proprio_id, date_ajout, date_dernier_entretien FROM plantes WHERE id=:id";

        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getSingleResult();
    }

    public List<PlantDTO> getPlantsByOwnerId(long id) {
        String request = "SELECT id, nom, proprio_id, date_ajout, date_dernier_entretien FROM plantes WHERE proprio_id=:id";
        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getResultList();
    }
}
