package com.epam.spring.core.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexey-Ivanovskiy on 03.03.2017.
 */
@Entity
@Table(name = "roles")
public class UserRole extends DomainObject implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 655028145987433327L;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    public UserRole() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
