package org.arosaje.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.arosaje.entities.Advice;
import org.arosaje.entities.Plant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UTILISATEURS")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Integer id;
    @Column(name = "PRENOM", length = 50)
    private String firstname;
    @Column(name = "NOM", length = 50)
    private String lastname;
    @Column(name = "EMAIL", unique = true, length = 255, nullable = false)
    private String email;
    @JsonIgnore
    @Column(name = "MOT_DE_PASSE", length = 255, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name= "TYPE", length = 25, nullable = false)
    private String type;
    @JsonIgnore
    @OneToMany(mappedBy = "owner_user")
    private Set<Plant> owned_plants;
    @JsonIgnore
    @OneToMany(mappedBy = "guardian_user")
    private Set<Plant> guardianed_plants;
    @JsonIgnore
    @OneToMany(mappedBy = "botanist")
    private Set<Advice> advices;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
