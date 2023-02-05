package org.arosaje.dto;

import java.util.Date;

public class PhotoDTO {

    long id;
    long plante_id;
    long utilisateur_id;
    Date date_prise;
    String url;

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

    public long getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public Date getDate_prise() {
        return date_prise;
    }

    public void setDate_prise(Date date_prise) {
        this.date_prise = date_prise;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PhotoDTO{" +
                "id=" + id +
                ", plante_id=" + plante_id +
                ", utilisateur_id=" + utilisateur_id +
                ", date_prise=" + date_prise +
                ", url='" + url + '\'' +
                '}';
    }
}
