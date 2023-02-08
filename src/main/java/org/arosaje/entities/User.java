package org.arosaje.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UTILISATEURS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOT_DE_PASSE")
    private String pwd;
    @Column(name= "TYPE")
    private String type;
    @Embedded
    private UserInfo userInfo;


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
