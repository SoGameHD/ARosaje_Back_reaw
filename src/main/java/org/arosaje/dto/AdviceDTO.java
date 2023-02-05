package org.arosaje.dto;

import java.util.Date;

public class AdviceDTO {
    long id;
    long plante_id;
    long botaniste_id;
    String contenu;
    Date date_ajout;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlante_id() {
        return plante_id;
    }

    public void setPlante_id(long plante_id) {
        this.plante_id = plante_id;
    }

    public long getBotaniste_id() {
        return botaniste_id;
    }

    public void setBotaniste_id(long botaniste_id) {
        this.botaniste_id = botaniste_id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(Date date_ajout) {
        this.date_ajout = date_ajout;
    }

    @Override
    public String toString() {
        return "AdviceDTO{" +
                "id=" + id +
                ", plante_id=" + plante_id +
                ", botaniste_id=" + botaniste_id +
                ", contenu='" + contenu + '\'' +
                ", date_ajout=" + date_ajout +
                '}';
    }
}
