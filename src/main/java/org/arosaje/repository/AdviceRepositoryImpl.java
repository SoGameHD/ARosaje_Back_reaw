package org.arosaje.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.arosaje.dto.AdviceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdviceRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<AdviceDTO> getAdviceByPlantId(long id) {
        String request = "SELECT id, plante_id, botaniste_id, contenu, date_ajout FROM conseils WHERE plante_id=:id";

        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getResultList();
    }
    public Object getAdviceById(long id) {
        String request = "SELECT id, plante_id, botaniste_id, contenu, date_ajout FROM conseils WHERE id=:id";

        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getSingleResult();
    }
}
