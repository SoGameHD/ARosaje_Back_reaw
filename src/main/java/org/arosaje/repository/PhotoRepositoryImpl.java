package org.arosaje.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.arosaje.dto.PhotoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<PhotoDTO> getPhotoByPlantId(long id) {
        String request = "SELECT id, plante_id, utilisateur_id, date_prise, url FROM photos WHERE plante_id=:id";

        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getResultList();
    }

    public Object getPhotoById(long id) {
        String request = "SELECT id, plante_id, utilisateur_id, date_prise, url FROM photos WHERE id=:id";

        Query query = entityManager.createNativeQuery(request)
                .setParameter("id", id);

        return query.getSingleResult();
    }
}
