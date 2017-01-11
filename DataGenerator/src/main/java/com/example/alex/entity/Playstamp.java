package com.example.alex.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYSTAMPS", schema = "IN130062", catalog = "")
public class Playstamp {
    private long playstampid;
    private Timestamp played;

    @Id
    @Column(name = "PLAYSTAMPID")
    public long getPlaystampid() {
        return playstampid;
    }

    public void setPlaystampid(long playstampid) {
        this.playstampid = playstampid;
    }

    @Basic
    @Column(name = "PLAYED")
    public Timestamp getPlayed() {
        return played;
    }

    public void setPlayed(Timestamp played) {
        this.played = played;
    }


}
