package com.epam.spring.core.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexey-Ivanovskiy on 12.03.2017.
 */
@Entity
@Table(name = "user_account")
public class UserAccount extends DomainObject implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 7519363918000493353L;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account")
    private double account;

    public UserAccount() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
