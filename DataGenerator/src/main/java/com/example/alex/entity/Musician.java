package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "MUSICIANS", schema = "IN130062", catalog = "")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musician musician = (Musician) o;

        if (musicianid != musician.musicianid) return false;
        if (musicianname != null ? !musicianname.equals(musician.musicianname) : musician.musicianname != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (musicianid ^ (musicianid >>> 32));
        result = 31 * result + (musicianname != null ? musicianname.hashCode() : 0);
        return result;
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
