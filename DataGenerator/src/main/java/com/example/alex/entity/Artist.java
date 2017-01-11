package com.example.alex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ARTISTS", schema = "IN130062")
public class Artist {
    @Id
    @SequenceGenerator(name = "artistSeq", sequenceName = "ARTISTID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artistSeq")
    @Column(name = "ARTISTID")
    private long artistid;
    private String artistname;

    @OneToMany(mappedBy="albumArtist" , fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Album> artistAlbums = new ArrayList<Album>();;

    public Artist() {

    }

    public Artist(String artistname) {
        this.artistname = artistname;
    }


    public long getArtistid() {
        return artistid;
    }

    public void setArtistid(long artistid) {
        this.artistid = artistid;
    }

    public Collection<Album> getArtistAlbums() {
        return artistAlbums;
    }

    public void setArtistAlbums(Collection<Album> artistAlbums) {
        this.artistAlbums = artistAlbums;
    }

    public void addAlbum(Album album) {
        if (!getArtistAlbums().contains(album)) {
            getArtistAlbums().add(album);
        }
        if (album.getAlbumArtist() != this) {
            album.setAlbumArtist(this);
        }
    }

    @Basic
    @Column(name = "ARTISTNAME")
    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

}
