package org.arosaje.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Embeddable
public class UserInfo {
    @Column(name = "PRENOM")
    private String first_name;
    @Column(name = "NOM")
    private String last_name;

    @OneToMany(mappedBy = "user")
    private Set<Plant> plants;
}
