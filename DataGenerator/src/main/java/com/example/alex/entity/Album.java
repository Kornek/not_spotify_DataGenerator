package com.example.alex.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "ALBUMS", schema = "IN130062", catalog = "")
public class Album {
    private long albumid;
    private String albumname;
    private byte[] coverimage;

    @Id
    @Column(name = "ALBUMID")
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
