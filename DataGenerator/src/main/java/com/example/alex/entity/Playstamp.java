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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playstamp playstamp = (Playstamp) o;

        if (playstampid != playstamp.playstampid) return false;
        if (played != null ? !played.equals(playstamp.played) : playstamp.played != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (playstampid ^ (playstampid >>> 32));
        result = 31 * result + (played != null ? played.hashCode() : 0);
        return result;
    }
}
