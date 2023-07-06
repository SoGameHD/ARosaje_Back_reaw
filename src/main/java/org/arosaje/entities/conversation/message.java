package org.arosaje.entities.conversation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.arosaje.entities.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONVERSATION")
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="CONVERSATION_ID")
    private Conversation conversation;

    @Column(name = "message", length = 5000, nullable = false)
    private String message;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="UTILISATEUR_ID")
    private User user;

    public message() {
    }

    public message(Conversation conversation, String message, User user) {
        this.conversation = conversation;
        this.message = message;
        this.date = LocalDateTime.now();
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
