package org.arosaje.repository.Conversation;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RepositoryRestResource(exported = false)
public interface ConversationRepository extends CrudRepository<Conversation, Integer> {

    @Query("SELECT c FROM Conversation c LEFT JOIN c.message m WHERE m IS NULL")
    List<Conversation> findEmptyConversations();

    List<Conversation> findAllByUser(User user);

}
