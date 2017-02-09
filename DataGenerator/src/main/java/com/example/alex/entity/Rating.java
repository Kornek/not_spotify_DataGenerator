package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "RATINGS")
public class Rating {
    @Id
    @Column(name = "RATINGID")
    private long ratingid;

    @Column(name = "RATING")
    private Long rating;


    public long getRatingid() {
        return ratingid;
    }

    public void setRatingid(long ratingid) {
        this.ratingid = ratingid;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

}
