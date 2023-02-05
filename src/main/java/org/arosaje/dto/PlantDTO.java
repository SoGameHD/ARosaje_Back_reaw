package org.arosaje.dto;

import java.util.Date;

public class PlantDTO {
    long id;
    String nom;
    long proprio_id;
    Date date_ajout;
    Date date_dernier_entretien;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getProprio_id() {
        return proprio_id;
    }

    public void setProprio_id(long proprio_id) {
        this.proprio_id = proprio_id;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    public Date getDate_dernier_entretien() {
        return date_dernier_entretien;
    }

    public void setDate_dernier_entretien(Date date_dernier_entretien) {
        this.date_dernier_entretien = date_dernier_entretien;
    }

    @Override
    public String toString() {
        return "PlantDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", proprio_id=" + proprio_id +
                ", date_ajout=" + date_ajout +
                ", date_dernier_entretien=" + date_dernier_entretien +
                '}';
    }
}
