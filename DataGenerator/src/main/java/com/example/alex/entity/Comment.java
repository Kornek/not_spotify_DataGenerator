package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "COMMENTS", schema = "IN130062", catalog = "")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentid != comment.commentid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (commentid ^ (commentid >>> 32));
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
