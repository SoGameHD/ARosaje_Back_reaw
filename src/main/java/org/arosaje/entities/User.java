package org.arosaje.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "UTILISATEURS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "EMAIL", unique = true, length = 255, nullable = false)
    private String email;
    @JsonIgnore
    @Column(name = "MOT_DE_PASSE", length = 255, nullable = false)
    private String pwd;
    @Column(name= "TYPE", length = 25, nullable = false)
    private String type;
    @Embedded
    private UserInfo userInfo;

    public User() {
    }

    public User(String email, String pwd, String type, UserInfo userInfo) {
        this.email = email;
        this.pwd = pwd;
        this.type = type;
        this.userInfo = userInfo;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

}
