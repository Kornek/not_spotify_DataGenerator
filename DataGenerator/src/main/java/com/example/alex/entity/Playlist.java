package com.example.alex.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYLISTS", schema = "IN130062", catalog = "")
public class Playlist {
    @Id
    @Column(name = "PLAYLISTID")
    private long playlistid;
    private String playlistname;
    private Time created;



    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }

    @Basic
    @Column(name = "PLAYLISTNAME")
    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    @Basic
    @Column(name = "CREATED")
    public Time getCreated() {
        return created;
    }

    public void setCreated(Time created) {
        this.created = created;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (
            name = "PLAYLISTSONGS",
            joinColumns = @JoinColumn(name = "PLAYLISTID"),
            inverseJoinColumns = @JoinColumn(name = "SONGID")
    )
    private Collection<Song> songs;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (playlistid != playlist.playlistid) return false;
        if (playlistname != null ? !playlistname.equals(playlist.playlistname) : playlist.playlistname != null)
            return false;
        if (created != null ? !created.equals(playlist.created) : playlist.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (playlistid ^ (playlistid >>> 32));
        result = 31 * result + (playlistname != null ? playlistname.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
