package org.arosaje.entities;

import jakarta.persistence.*;
import org.arosaje.entities.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PLANTES")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "TITRE", length = 100, nullable = false)
    private String title;
    @Column(name = "DESCRIPTION", length = 1000, nullable = false)
    private String description;
    @Column(name = "DATE_AJOUT")
    private LocalDateTime create_date;
    @Column(name = "DATE_DERNIER_ENTRETIEN")
    private LocalDateTime last_update_date;
    @Column(name="DATE_DEBUT")
    private LocalDate start_date;
    @Column(name="DATE_FIN")
    private LocalDate end_date;
    @Column(name = "GARDER")
    private Boolean guard;
    @ManyToOne
    @JoinColumn(name="PROPRIO_ID")
    private User owner_user;
    @ManyToOne
    @JoinColumn(name="GUARDIEN_ID")
    private User guardian_user;
    @OneToMany(mappedBy = "plant", cascade = CascadeType.REMOVE)
    private Set<Advice> advices;
    @OneToMany(mappedBy = "plant", cascade = CascadeType.REMOVE)
    private Set<Picture> pictures;

    {
        guard = false;
        create_date = LocalDateTime.now();
    }

    public Plant() {
    }

    public Plant(String title, LocalDateTime last_update_date, LocalDate start_date, LocalDate end_date, Boolean guard, User owner_user, User guardian_user) {
        this.title = title;
        this.last_update_date = last_update_date;
        this.start_date = start_date;
        this.end_date = end_date;
        this.guard = guard;
        this.owner_user = owner_user;
        this.guardian_user = guardian_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(LocalDateTime last_update_date) {
        this.last_update_date = last_update_date;
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

    public Boolean getGuard() {
        return guard;
    }

    public void setGuard(Boolean guard) {
        this.guard = guard;
    }

    public User getOwner_user() {
        return owner_user;
    }

    public void setOwner_user(User owner_user) {
        this.owner_user = owner_user;
    }

    public User getGuardian_user() {
        return guardian_user;
    }

    public void setGuardian_user(User guardian_user) {
        this.guardian_user = guardian_user;
    }

    public Set<Advice> getAdvices() {
        return advices;
    }

    public void setAdvices(Set<Advice> advices) {
        this.advices = advices;
    }

    public List<String> getPictures() {
        List<String> href = new ArrayList<>();
        for(Picture pic : pictures) {
            href.add("localhost:8080/plants/" + getId() + "/pictures/"+pic.getId());
        }
        return href;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", create_date=" + create_date +
                ", last_update_date=" + last_update_date +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", guard=" + guard +
                ", owner_user=" + owner_user +
                ", guardian_user=" + guardian_user +
                ", advices=" + advices +
                ", pictures=" + pictures +
                '}';
    }
}
