package com.example.alex.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Alex on 16.12.2016.
 */
public class PlaylistsongPK implements Serializable {
    private long playlistid;
    private long songid;

    @Column(name = "PLAYLISTID")
    @Id
    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }

    @Column(name = "SONGID")
    @Id
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

        PlaylistsongPK that = (PlaylistsongPK) o;

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
}
