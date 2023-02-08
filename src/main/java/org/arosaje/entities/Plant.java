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
    @ManyToOne
    @JoinColumn(name="PROPRIO_ID")
    private User owner_user;
    @ManyToOne
    @JoinColumn(name="GUARDIEN_ID")
    private User guardian_user;
    @OneToMany(mappedBy = "plant")
    private Set<Advice> advices;
    @OneToMany(mappedBy = "plant")
    private Set<Picture> pictures;

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

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", create_date='" + create_date + '\'' +
                ", last_update_date='" + last_update_date + '\'' +
                '}';
    }
}
