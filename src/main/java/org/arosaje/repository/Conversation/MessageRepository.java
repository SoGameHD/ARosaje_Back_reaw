package org.arosaje.repository.Conversation;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.conversation.message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RepositoryRestResource(exported = false)
public interface MessageRepository extends CrudRepository<message, Integer> {

    List<message> findAllByConversation(Conversation conversation);
}
