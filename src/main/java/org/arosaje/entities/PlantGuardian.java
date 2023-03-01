package org.arosaje.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "HISTORIQUE_GARDIENNAGE")
public class PlantGuardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "PLANTE_ID")
    private Plant plant;
    @Column(name = "DATE_DEBUT")
    private LocalDate start_date;
    @Column(name = "DATE_FIN")
    private LocalDate end_date;

    public PlantGuardian() {
    }

    public PlantGuardian(User user, Plant plant, LocalDate start_date, LocalDate end_date) {
        this.user = user;
        this.plant = plant;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "PlantGuardian{" +
                "id=" + id +
                ", user=" + user +
                ", plant=" + plant +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }

}
