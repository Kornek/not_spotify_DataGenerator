package com.example.alex.facade;

import com.example.alex.entity.Rating;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Alex on 09.02.2017.
 */
public class RatingFacade implements Facade<Rating>{

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();

    public void persist(Rating entity) {

    }

    public void merge(Rating entity) {

    }

    public void remove(Rating entity) {

    }

    public Rating find(Rating entity) {
        return null;
    }

    public void close() {

    }
}
