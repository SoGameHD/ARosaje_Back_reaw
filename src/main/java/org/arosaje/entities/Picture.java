package org.arosaje.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.arosaje.entities.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "PHOTO")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column( name = "nom", length = 255, nullable = false)
    private String fileName;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column( name = "type", length = 255, nullable = false)
    private String mimeType;
    @Column( name = "taille", length = 1000 ,nullable = false)
    private long size;
    @JsonIgnore
    @Lob
    @Column( name = "contenu", columnDefinition = "bytea")
    private byte[] content;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "plante_id")
    private Plant plant;

    public Picture() {
    }

    public Picture(String fileName, LocalDateTime date, String mimeType, long size) {
        this.fileName = fileName;
        this.date = date;
        this.mimeType = mimeType;
        this.size = size;
    }

    public Picture(String fileName, LocalDateTime now, String contentType, long size, byte[] bytes, Plant  plant) {
        this.fileName = fileName;
        this.date = now;
        this.size = size;
        this.mimeType = contentType;
        this.content = bytes;
        this.plant = plant;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", date=" + date +
                ", mimeType='" + mimeType + '\'' +
                ", size=" + size +
                '}';
    }

}
