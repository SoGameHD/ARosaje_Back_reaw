package org.arosaje.controller;

import org.arosaje.entities.conversation.Conversation;
import org.arosaje.entities.conversation.message;
import org.arosaje.service.Conversation.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;

    @GetMapping("/message")
    public List<message> getMessage(@RequestParam Integer conv_id) {
        return conversationService.getMessageByConversationId(conv_id);
    }

    @GetMapping("/conversation")
    public List<Conversation> getConversation(@RequestParam Integer user_id) {
        return conversationService.getConversationByUserId(user_id);
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
