package com.example.alex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ARTISTS")
public class Artist {
    @Id
    @SequenceGenerator(name = "artistSeq", sequenceName = "ARTISTID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artistSeq")
    @Column(name = "ARTISTID")
    protected long artistid;

    @Column(name = "ARTISTNAME")
    private String artistname;

    @OneToMany(mappedBy="albumArtist" , cascade = CascadeType.ALL)
    private Collection<Album> artistAlbums = new ArrayList<Album>();

    @OneToMany(mappedBy="songArtist" , cascade = CascadeType.ALL)
    private Collection<Song> artistSongs = new ArrayList<Song>();

    //region Ctor
    public Artist() {

    }

    public Artist(String artistname) {
        this.artistname = artistname;
    }
    //endregion

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
            System.out.println("album added");
        }
        if (album.getAlbumArtist() != this) {
            System.out.println("recursion");
            album.setAlbumArtist(this);
        }
    }


    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public Collection<Song> getArtistSongs() {
        return artistSongs;
    }

    public void setArtistSongs(Collection<Song> artistSongs) {
        this.artistSongs = artistSongs;
    }

    public void addArtistSong(Song song) {
        if (!getArtistSongs().contains(song)) {
            artistSongs.add(song);
        }
        if(song.getSongArtist() != this){
            song.setSongArtist(this);
        }
    }
}


