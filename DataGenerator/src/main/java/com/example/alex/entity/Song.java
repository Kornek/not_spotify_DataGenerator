package com.example.alex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "SONGS")
public class Song implements Serializable{
    @Id
    @SequenceGenerator(name = "songSeq", sequenceName = "SONGID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songSeq")
    @Column(name = "SONGID")
    protected long songid;

    @Column(name = "SONGNAME")
    private String songname;

    @Column(name = "SONGFILE")
    private byte[] songfile;

    @Column(name = "TRACKNR")
    private Long tracknr;

    @ManyToOne
    @JoinColumn(name="ALBUMID")
    private Album songAlbum;

    @ManyToOne
    @JoinColumn(name="ARTISTID")
    private Artist songArtist;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    private Collection<Playlist> playlists;

    @ManyToOne
    @JoinColumn(name="GENREID")
    private Genre songGenre;

    @OneToMany(mappedBy="playstampSong" , cascade = CascadeType.ALL)
    private Collection<Playstamp> songPlaystamp = new ArrayList<Playstamp>();

    //region Ctor
    public Song() {
    }

    public Song(String songname, byte[] songfile, Long tracknr) {
        this.songname = songname;
        this.songfile = songfile;
        this.tracknr = tracknr;
    }
    //endregion

    //region Getter/Setter

    public long getSongid() {
        return songid;
    }

    public void setSongid(long songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public byte[] getSongfile() {
        return songfile;
    }

    public void setSongfile(byte[] songfile) {
        this.songfile = songfile;
    }

    public Long getTracknr() {
        return tracknr;
    }

    public void setTracknr(Long tracknr) {
        this.tracknr = tracknr;
    }

    public Album getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(Album songAlbum) {
        this.songAlbum = songAlbum;
        songAlbum.addAlbumSong(this);
    }

    public Artist getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(Artist songArtist) {
        this.songArtist = songArtist;
        songArtist.addArtistSong(this);
    }

    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Collection<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Genre getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(Genre songGenre) {
        this.songGenre = songGenre;
        songGenre.addGenreSong(this);
    }

    public Collection<Playstamp> getSongPlaystamp() {
        return songPlaystamp;
    }

    public void setSongPlaystamp(Collection<Playstamp> songPlaystamp) {
        this.songPlaystamp = songPlaystamp;
    }

    public void addSongPlaystamp(Playstamp playstamp){
        if (!getSongPlaystamp().contains(playstamp)) {
            getSongPlaystamp().add(playstamp);
        }
        if (playstamp.getPlaystampSong() != this) {
            playstamp.setPlaystampSong(this);
        }
    }

    //endregion
}
