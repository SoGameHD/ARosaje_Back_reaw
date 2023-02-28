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

    public Advice(Integer id, String content, LocalDateTime date) {
        this.id = id;
        this.content = content;
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advice advice = (Advice) o;
        return Objects.equals(id, advice.id) &&
                Objects.equals(content, advice.content) &&
                Objects.equals(date.format(DateTimeFormatter.ISO_DATE), advice.date.format(DateTimeFormatter.ISO_DATE));
    }
}
