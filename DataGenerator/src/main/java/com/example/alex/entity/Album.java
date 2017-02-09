package com.example.alex.entity;

import oracle.net.aso.s;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ALBUMS")
public class Album {
    @Id
    @SequenceGenerator(name = "albumSeq", sequenceName = "ALBUMID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albumSeq")
    @Column(name = "ALBUMID")
    private long albumid;

    @Column(name = "ALBUMNAME")
    private String albumname;

    @Column(name = "COVERIMAGE")
    private byte[] coverimage;

    @OneToMany(mappedBy="songAlbum" , cascade = CascadeType.ALL)
    private Collection<Song> albumSongs = new ArrayList<Song>();


    @ManyToOne
    @JoinColumn(name="ARTISTID")
    private Artist albumArtist;


    //region Ctor
    public Album() {
    }

    public Album(String albumname) {
        this.albumname = albumname;
    }

    public Album(String albumname, byte[] coverimage) {
        this.albumname = albumname;
        this.coverimage = coverimage;
    }
    //endregion

    //region Get/Set
    public long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(long albumid) {
        this.albumid = albumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public byte[] getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(byte[] coverimage) {
        this.coverimage = coverimage;
    }

    public Collection<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(Collection<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }

    public void addAlbumSong(Song song){
        if (!getAlbumSongs().contains(song)) {
            albumSongs.add(song);
        }
        if(song.getSongAlbum() != this){
            song.setSongAlbum(this);
        }
    }

    public Artist getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(Artist albumArtist) {
        this.albumArtist = albumArtist;
        System.out.println("artist added");
        albumArtist.addAlbum(this);
    }
    //endregion

}
