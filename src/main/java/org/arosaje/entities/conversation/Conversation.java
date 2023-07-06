package org.arosaje.entities.conversation;

import jakarta.persistence.*;

import org.arosaje.entities.user.User;

import java.util.Set;

@Entity
@Table(name = "CONVERSATION")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "NOM", length = 50, nullable = false)
    private String name;
    @ManyToMany
    @JoinColumn(name = "USER_ID")
    private Set<User> user;
    @OneToMany(mappedBy = "conversation", cascade = CascadeType.REMOVE)
    private Set<message> message;

    public Conversation() {
    }

    public Conversation(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<org.arosaje.entities.conversation.message> getMessage() {
        return message;
    }

    public void setMessage(Set<org.arosaje.entities.conversation.message> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", message=" + message +
                '}';
    }
}
