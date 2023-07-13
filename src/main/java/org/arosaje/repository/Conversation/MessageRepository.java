package org.arosaje.repository.Conversation;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.conversation.message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RepositoryRestResource(exported = false)
public interface MessageRepository extends CrudRepository<message, Integer> {


    @Modifying
    @Query("DELETE FROM message m WHERE m.date < :date")
    void deleteByDateBefore(@Param("date") LocalDateTime date);
    List<message> findAllByConversation(Conversation conversation);
}
