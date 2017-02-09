package com.example.alex.entity;

import com.sun.media.jfxmedia.events.PlayerStateEvent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "USERID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name = "USERID")
    private long userid;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "playstampUser", cascade = CascadeType.ALL)
    private Collection<Playstamp> userPlaystamp = new ArrayList<Playstamp>();

    //region GET/SET
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Playstamp> getUserPlaystamp() {
        return userPlaystamp;
    }

    public void setUserPlaystamp(Collection<Playstamp> userPlaystamp) {
        this.userPlaystamp = userPlaystamp;
    }

    public void addUserPlaystamp(Playstamp playstamp) {
        if (!getUserPlaystamp().contains(playstamp)) {
            getUserPlaystamp().add(playstamp);
        }
        if (playstamp.getPlaystampUser() != this) {
            playstamp.setPlaystampUser(this);
        }

    }

    //endregion

}
