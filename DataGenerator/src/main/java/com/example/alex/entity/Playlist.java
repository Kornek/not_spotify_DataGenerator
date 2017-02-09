package com.example.alex.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYLISTS")
public class Playlist {
    @Id
    @Column(name = "PLAYLISTID")
    private long playlistid;
    @Column(name = "PLAYLISTNAME")
    private String playlistname;
    @Column(name = "CREATED")
    private Time created;


    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

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


}
