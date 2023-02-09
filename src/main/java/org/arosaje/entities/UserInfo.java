package org.arosaje.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Embeddable
public class UserInfo {
    @Column(name = "PRENOM")
    private String first_name;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "NOM")
    private String last_name;

    @OneToMany(mappedBy = "owner_user")
    private Set<Plant> owned_plants;

    @OneToMany(mappedBy = "guardian_user")
    private Set<Plant> guardianed_plants;

    @OneToMany(mappedBy = "botanist")
    private Set<Advice> advices;
}
