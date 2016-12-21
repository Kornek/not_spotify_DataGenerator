package com.example.alex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "SONGS", schema = "IN130062")
public class Song implements Serializable{
    @Id
    @SequenceGenerator(name = "songSeq", sequenceName = "SONGID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songSeq")
    @Column(name = "SONGID")
    protected long songid;
    private String songname;
    private byte[] songfile;
    private Long tracknr;
    private Album albumsByAlbumid;
    private Artist artistsByArtistid;

    @ManyToOne
    @JoinColumn(name="ALBUMID", insertable=false, updatable=false)
    private Album songAlbum;

    @ManyToOne
    @JoinColumn(name="ARTISTID", insertable=false, updatable=false)
    private Artist songArtist;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    private Collection<Playlist> playlists;

    public Song() {
    }

    public Song(String songname, byte[] songfile, Long tracknr) {
        this.songname = songname;
        this.songfile = songfile;
        this.tracknr = tracknr;
    }

    //region Getter/Setter

    public long getSongid() {
        return songid;
    }

    public void setSongid(long songid) {
        this.songid = songid;
    }

    @Basic
    @Column(name = "SONGNAME")
    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    @Basic
    @Column(name = "SONGFILE")
    public byte[] getSongfile() {
        return songfile;
    }

    public void setSongfile(byte[] songfile) {
        this.songfile = songfile;
    }

    @Basic
    @Column(name = "TRACKNR")
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
    }

    public Artist getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(Artist songArtist) {
        this.songArtist = songArtist;
    }

    public Collection<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Collection<Playlist> playlists) {
        this.playlists = playlists;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (songid != song.songid) return false;
        if (songname != null ? !songname.equals(song.songname) : song.songname != null) return false;
        if (!Arrays.equals(songfile, song.songfile)) return false;
        if (tracknr != null ? !tracknr.equals(song.tracknr) : song.tracknr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (songid ^ (songid >>> 32));
        result = 31 * result + (songname != null ? songname.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(songfile);
        result = 31 * result + (tracknr != null ? tracknr.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID", nullable = false)
    public Album getAlbumsByAlbumid() {
        return albumsByAlbumid;
    }

    public void setAlbumsByAlbumid(Album albumsByAlbumid) {
        this.albumsByAlbumid = albumsByAlbumid;
    }

    @ManyToOne
    @JoinColumn(name = "ARTISTID", referencedColumnName = "ARTISTID")
    public Artist getArtistsByArtistid() {
        return artistsByArtistid;
    }

    public void setArtistsByArtistid(Artist artistsByArtistid) {
        this.artistsByArtistid = artistsByArtistid;
    }




}
