package org.arosaje.service.Conversation;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.conversation.message;
import org.arosaje.entities.user.User;
import org.arosaje.repository.Conversation.ConversationRepository;
import org.arosaje.repository.Conversation.MessageRepository;
import org.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    UserRepository userRepository;

    public void addMessage(Integer conv_id, Integer user_id, String contenu) {
        Conversation conversation = conversationRepository.findById(conv_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        message msg = new message(conversation, contenu, user);
        messageRepository.save(msg);
    }

    public void addConversation(String name, Integer sender, Integer recept, String contenu) {
        User senderUser = userRepository.findById(sender).orElse(null);
        User receptUser = userRepository.findById(recept).orElse(null);

        Conversation conversation = new Conversation(name);
        conversation.getUser().add(senderUser);
        conversation.getUser().add(receptUser);

        conversationRepository.save(conversation);

        addMessage(conversation.getId(), sender, contenu);
    }

    public List<Conversation> getConversationByUserId(Integer user_id) {
        User user = userRepository.findById(user_id).orElse(null);
        return conversationRepository.findAllByUser(user);
    }

    public List<message> getMessageByConversationId(Integer conv_id) {
        Conversation conversation = conversationRepository.findById(conv_id).orElse(null);
        return messageRepository.findAllByConversation(conversation);
    }
}
