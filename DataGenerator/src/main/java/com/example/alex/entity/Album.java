package com.example.alex.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ALBUMS", schema = "IN130062")
public class Album {
    @Id
    @SequenceGenerator(name = "albumSeq", sequenceName = "ALBUMID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albumSeq")
    @Column(name = "ALBUMID")
    protected long albumid;
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

    @Basic
    @Column(name = "ALBUMNAME")
    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    @Basic
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (albumid != album.albumid) return false;
        if (albumname != null ? !albumname.equals(album.albumname) : album.albumname != null) return false;
        if (!Arrays.equals(coverimage, album.coverimage)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (albumid ^ (albumid >>> 32));
        result = 31 * result + (albumname != null ? albumname.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(coverimage);
        return result;
    }
}
