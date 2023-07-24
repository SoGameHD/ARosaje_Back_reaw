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
import java.util.Set;

@Service
public class ConversationService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    UserRepository userRepository;

    public void addMessage(Integer conv_id, Integer user_id, String contenu) throws Exception {
        Conversation conversation = conversationRepository.findById(conv_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        message msg = new message(conversation, contenu, user);
        messageRepository.save(msg);
    }

    public void addConversation(String name, Integer sender, Integer recept, String contenu) throws Exception {
        if(sender == recept) {
            return;
        }

        User senderUser = userRepository.findById(sender).orElse(null);
        User receptUser = userRepository.findById(recept).orElse(null);
        List<Conversation> conversations = conversationRepository.findAllByUser(senderUser);

        for(Conversation currentConversation : conversations) {
            Set<User> users = currentConversation.getUser();
            if(users.contains(senderUser) && users.contains(receptUser) ){
                addMessage(currentConversation.getId(), sender, contenu);
                return;
            }
        }
        
        Conversation conversation = new Conversation(name);
        conversation.getUser().add(senderUser);
        conversation.getUser().add(receptUser);

        conversationRepository.save(conversation);

        addMessage(conversation.getId(), sender, contenu);
    }

    public List<Conversation> getConversationByUserId(Integer user_id) {
        Boolean userFind = false;
        User user = userRepository.findById(user_id).orElse(null);
        List<Conversation> conversations = conversationRepository.findAllByUser(user);
        for(Conversation conversation : conversations) {
            for(User currentUser : conversation.getUser()) {
                if(currentUser.getId() == user.getId()) {
                    userFind = true;
                } else {
                    String firstnameFirstChar = currentUser.getFirstname().substring(0, 1).toUpperCase();
                    String firstnameRestOfString = currentUser.getFirstname().substring(1).toLowerCase();
                    conversation.setName(firstnameFirstChar + firstnameRestOfString + " " + currentUser.getLastname().toUpperCase());
                }
            }
        }
        if(userFind == false) {
            return null;
        }
        return conversations;
    }

    public List<message> getMessageByConversationId(Integer conv_id) {
        Conversation conversation = conversationRepository.findById(conv_id).orElse(null);
        return messageRepository.findAllByConversation(conversation);
    }

    public Conversation getConversationByConvId(Integer id, Integer user_id) {
        Boolean userFind = false;
        User user = userRepository.findById(user_id).orElse(null);
        Conversation conversation = conversationRepository.findById(id).orElse(null);
        for(User currentUser : conversation.getUser()) {
            if(currentUser.getId() == user.getId()) {
                userFind = true;
            } else {
                String firstnameFirstChar = currentUser.getFirstname().substring(0, 1).toUpperCase();
                String firstnameRestOfString = currentUser.getFirstname().substring(1).toLowerCase();
                conversation.setName(firstnameFirstChar + firstnameRestOfString + " " + currentUser.getLastname().toUpperCase());
            }
        }
        if(userFind == false) {
            return null;
        }
        return conversation;
    }
}
