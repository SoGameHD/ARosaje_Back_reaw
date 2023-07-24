package org.arosaje.controller;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.conversation.message;
import org.arosaje.service.Conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @GetMapping("/message")
    public List<message> getMessage(@RequestParam Integer conv_id) {
        List<message> messages = conversationService.getMessageByConversationId(conv_id);

        // Trier la liste des messages par date (du plus récent au moins récent)
        Collections.sort(messages, Comparator.comparing(message::getDate).reversed());

        return messages;
    }

    @GetMapping("/conversation")
    public List<Conversation> getConversation(@RequestParam Integer user_id) {
        List<Conversation> conversations = conversationService.getConversationByUserId(user_id);
        if (conversations == null) {
            return conversations;
        }
        // Trie la liste de conversations en utilisant un comparateur personnalisé
        Collections.sort(conversations, new Comparator<Conversation>() {
            @Override
            public int compare(Conversation conv1, Conversation conv2) {
                // Convertit le set de messages en listes pour chaque conversation
                List<message> messages1 = new ArrayList<>(conv1.getMessage());
                List<message> messages2 = new ArrayList<>(conv2.getMessage());

                // Obtient les dates des derniers messages pour les deux conversations
                LocalDateTime lastMessageDate1 = messages1.get(messages1.size() - 1).getDate();
                LocalDateTime lastMessageDate2 = messages2.get(messages2.size() - 1).getDate();

                // Compare les dates du dernier message pour ordonner les conversations
                return lastMessageDate2.compareTo(lastMessageDate1);
            }
        });

        return conversations;
    }

    @GetMapping("/conversation/{id}")
    public Conversation getConversationById(@PathVariable Integer id, @RequestParam Integer user_id) {
        return conversationService.getConversationByConvId(id, user_id);
    }

    @PostMapping("/conversation")
    public void addConversation(@RequestParam(name="name") String name, @RequestParam(name = "sender") Integer sender, @RequestParam(name="recept") Integer recept,  @RequestParam(name="content") String content) throws Exception {
        conversationService.addConversation(name, sender, recept, content);
    }

    @PostMapping("/message")
    public void addMessage(@RequestParam(name="conv") Integer conv_id, @RequestParam(name = "user") Integer user_id, @RequestParam(name="content") String content) throws Exception {
        conversationService.addMessage(conv_id, user_id, content);
    }
}
