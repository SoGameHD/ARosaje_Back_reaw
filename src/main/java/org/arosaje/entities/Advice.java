package org.arosaje.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "CONSEILS")
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "CONTENU", length = 5000, nullable = false)
    private String content;

    @Column(name = "DATE")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "PLANTE_ID")
    private Plant plant;
    @ManyToOne
    @JoinColumn(name = "BOTANISTE_ID")
    private User botanist;

    {
        date = LocalDateTime.now();
    }

    public Advice() {
    }

    public Advice(String content) {
        this.content = content;
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

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", plant=" + plant +
                '}';
    }
}
