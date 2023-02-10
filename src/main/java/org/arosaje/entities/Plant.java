package org.arosaje.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PLANTES")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITRE")
    private String title;
    @Column(name = "DATE_AJOUT")
    private String create_date;
    @Column(name = "DATE_DERNIER_ENTRETIEN")
    private String last_update_date;
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
    }

    public Plant() {
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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
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

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", create_date='" + create_date + '\'' +
                ", last_update_date='" + last_update_date + '\'' +
                ", owner_user=" + owner_user +
                ", guardian_user=" + guardian_user +
                ", advices=" + advices +
                ", pictures=" + pictures +
                '}';
    }


}
