package org.arosaje.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONSEILS")
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "CONTENU", length = 5000)
    private String content;

    @Column(name = "DATE")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "PLANTE_ID")
    private Plant plant;
    @ManyToOne
    @JoinColumn(name = "BOTANISTE_ID")
    private User botanist;


    public Advice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
