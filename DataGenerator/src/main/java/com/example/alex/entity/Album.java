package com.example.alex.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ALBUMS", schema = "IN130062")
@SequenceGenerator(name = "albumSeq", sequenceName = "ALBUMID_SEQ", allocationSize=1)
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albumSeq")
    @Column(name = "ALBUMID")
    protected long albumid;

    @Column(name = "ALBUMNAME")
    private String albumname;
    private byte[] coverimage;

    @OneToMany(mappedBy="songAlbum" , fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Collection<Song> albumSongs;

    @ManyToOne
    @JoinColumn(name="ARTISTID", insertable=false, updatable=false)
    private Artist albumArtist;

    public Album() {
    }

    public Album(String albumname) {
        this.albumname = albumname;
    }

    public Album(String albumname, byte[] coverimage) {
        this.albumname = albumname;
        this.coverimage = coverimage;
    }

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

    @Column(name = "COVERIMAGE")
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

    public Artist getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(Artist albumArtist) {
        this.albumArtist = albumArtist;
    }

}
