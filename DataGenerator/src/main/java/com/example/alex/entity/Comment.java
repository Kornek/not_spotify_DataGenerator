package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "COMMENTS")
public class Comment {
    private long commentid;
    private Album albumsByAlbumid;

    @Id
    @Column(name = "COMMENTID")
    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    @ManyToOne
    @JoinColumn(name = "ALBUMID", referencedColumnName = "ALBUMID")
    public Album getAlbumsByAlbumid() {
        return albumsByAlbumid;
    }

    public void setAlbumsByAlbumid(Album albumsByAlbumid) {
        this.albumsByAlbumid = albumsByAlbumid;
    }
}
