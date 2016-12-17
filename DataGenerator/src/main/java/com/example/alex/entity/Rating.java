package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "RATINGS", schema = "IN130062", catalog = "")
public class Rating {
    private long ratingid;
    private Long rating;

    @Id
    @Column(name = "RATINGID")
    public long getRatingid() {
        return ratingid;
    }

    public void setRatingid(long ratingid) {
        this.ratingid = ratingid;
    }

    @Basic
    @Column(name = "RATING")
    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (ratingid != rating1.ratingid) return false;
        if (rating != null ? !rating.equals(rating1.rating) : rating1.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ratingid ^ (ratingid >>> 32));
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
