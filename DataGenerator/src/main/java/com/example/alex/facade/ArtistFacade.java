package com.example.alex.facade;

import com.example.alex.entity.Album;
import com.example.alex.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex on 21.12.2016.
 */
public class ArtistFacade {
    @PersistenceContext
    public EntityManager em;

    public void save(Artist artist){
        em.persist(artist);
    }
}
