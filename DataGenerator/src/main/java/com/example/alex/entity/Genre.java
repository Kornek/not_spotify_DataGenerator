package com.example.alex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "GENRES", schema = "IN130062", catalog = "")
public class Genre {
    private long genreid;

    @Id
    @Column(name = "GENREID")
    public long getGenreid() {
        return genreid;
    }

    public void setGenreid(long genreid) {
        this.genreid = genreid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (genreid != genre.genreid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (genreid ^ (genreid >>> 32));
    }
}
