package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "MUSICIANS")
public class Musician {
    private long musicianid;
    private String musicianname;
    private Artist artistsByArtistid;

    @Id
    @Column(name = "MUSICIANID")
    public long getMusicianid() {
        return musicianid;
    }

    public void setMusicianid(long musicianid) {
        this.musicianid = musicianid;
    }

    @Basic
    @Column(name = "MUSICIANNAME")
    public String getMusicianname() {
        return musicianname;
    }

    public void setMusicianname(String musicianname) {
        this.musicianname = musicianname;
    }

    @ManyToOne
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID", nullable = false)
    public Artist getArtistsByArtistid() {
        return artistsByArtistid;
    }

    public void setArtistsByArtistid(Artist artistsByArtistid) {
        this.artistsByArtistid = artistsByArtistid;
    }
}
