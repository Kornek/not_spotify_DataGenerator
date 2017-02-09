package com.example.alex.entity;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYSTAMPS")
public class Playstamp {
    @Id
    @SequenceGenerator(name = "playstampSeq", sequenceName = "PLAYSTAMPID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playstampSeq")
    @Column(name = "PLAYSTAMPID")
    private long playstampid;
    @Column(name = "PLAYED")
    private Timestamp played;

    @ManyToOne
    @JoinColumn(name="SONGID")
    private Song playstampSong;

    @ManyToOne
    @JoinColumn(name="USERID")
    private User playstampUser;


    public long getPlaystampid() {
        return playstampid;
    }

    public void setPlaystampid(long playstampid) {
        this.playstampid = playstampid;
    }


    public Timestamp getPlayed() {
        return played;
    }

    public void setPlayed(Timestamp played) {
        this.played = played;
    }

    public Song getPlaystampSong() {
        return playstampSong;
    }

    public void setPlaystampSong(Song song) {
        this.playstampSong = song;
        song.addSongPlaystamp(this);
    }

    public User getPlaystampUser() {
        return playstampUser;
    }

    public void setPlaystampUser(User user) {
        this.playstampUser = user;
        user.addUserPlaystamp(this);

    }
}
