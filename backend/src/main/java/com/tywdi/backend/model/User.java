package com.tywdi.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tywdi.backend.model.enums.Role;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Organisation: Codemerger Ldt.
 * Project: backend
 * Package: com.tywdi.backend.model
 * Date: 10.08.2020
 *
 * @author: Michael Bielang, b137ang@codemerger.com.
 * @version: java version "14" 2020-03-17
 */
@Entity
@Data
public class User implements UserDetails {

    // TODO - michael.bielang: 22.09.2020 make sequence possible for both env.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(allocationSize = 1, sequenceName = "USER_SEQ", name = "USER_SEQ")*/
    private Long id;

    @NaturalId
    private String email;
    private String username;

    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Version
    @JsonIgnore
    private int version;

    public User() {
        //dflt ctor for hibernate
    }

    public User(final String username, final String email, final String password, final Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> grantList = new ArrayList<>();

        grantList.add(new SimpleGrantedAuthority(this.role.getAuthority()));

        return grantList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
