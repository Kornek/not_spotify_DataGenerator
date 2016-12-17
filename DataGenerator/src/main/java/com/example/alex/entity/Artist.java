package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ARTISTS", schema = "IN130062", catalog = "")
public class Artist {
    private long artistid;
    private String artistname;

    @Id
    @Column(name = "ARTISTID")
    public long getArtistid() {
        return artistid;
    }

    public void setArtistid(long artistid) {
        this.artistid = artistid;
    }

    @Basic
    @Column(name = "ARTISTNAME")
    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (artistid != artist.artistid) return false;
        if (artistname != null ? !artistname.equals(artist.artistname) : artist.artistname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (artistid ^ (artistid >>> 32));
        result = 31 * result + (artistname != null ? artistname.hashCode() : 0);
        return result;
    }
}
