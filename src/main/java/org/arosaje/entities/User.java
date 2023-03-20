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
    @Column(name = "MOT_DE_PASSE", length = 255, nullable = false)
    private String pwd;
    @Column(name= "ROLE", length = 25, nullable = false)
    private String role;
    @Embedded
    private UserInfo userInfo;

    public User() {
    }

    public User(String email, String pwd, String role, UserInfo userInfo) {
        this.email = email;
        this.pwd = pwd;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
