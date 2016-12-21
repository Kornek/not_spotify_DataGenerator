package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "PLAYLISTSONGS", schema = "IN130062")
public class Playlistsong {
    private long playlistid;
    private long songid;
    private Playlist playlistsByPlaylistid;

    @Id
    @Column(name = "PLAYLISTID")
    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }

    @Id
    @Column(name = "SONGID")
    public long getSongid() {
        return songid;
    }

    public void setSongid(long songid) {
        this.songid = songid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlistsong that = (Playlistsong) o;

        if (playlistid != that.playlistid) return false;
        if (songid != that.songid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (playlistid ^ (playlistid >>> 32));
        result = 31 * result + (int) (songid ^ (songid >>> 32));
        return result;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "PLAYLISTID", referencedColumnName = "PLAYLISTID")
    public Playlist getPlaylistsByPlaylistid() {
        return playlistsByPlaylistid;
    }

    public void setPlaylistsByPlaylistid(Playlist playlistsByPlaylistid) {
        this.playlistsByPlaylistid = playlistsByPlaylistid;
    }
}
