package com.example.alex.facade;

import com.example.alex.entity.Album;
import com.example.alex.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex on 20.12.2016.
 */
public class AlbumFacade {

    @PersistenceContext
    public EntityManager em;

    public void save(Album album){
        em.getTransaction().begin();
        em.persist(album);
        em.flush();
        em.getTransaction().commit();
    }
}
