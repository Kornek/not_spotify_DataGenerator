package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYLISTSONGS")
public class Playlistsong {
    @Id
    @Column(name = "PLAYLISTID")
    private long playlistid;
    @Id
    @Column(name = "SONGID")
    private long songid;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "PLAYLISTID", referencedColumnName = "PLAYLISTID")
    private Playlist playlistsByPlaylistid;


    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }


    public long getSongid() {
        return songid;
    }

    public void setSongid(long songid) {
        this.songid = songid;
    }

    public Playlist getPlaylistsByPlaylistid() {
        return playlistsByPlaylistid;
    }

    public void setPlaylistsByPlaylistid(Playlist playlistsByPlaylistid) {
        this.playlistsByPlaylistid = playlistsByPlaylistid;
    }
}
