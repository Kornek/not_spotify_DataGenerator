package com.example.alex.facade;

import com.example.alex.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex on 16.12.2016.
 */
public class SongsFacade {
    @PersistenceContext
    public EntityManager em;

    public void save(Song song){
        em.persist(song);
    }

}
