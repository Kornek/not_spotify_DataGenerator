package com.example.alex.facade;

import com.example.alex.entity.Album;
import com.example.alex.entity.Artist;
import com.example.alex.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex on 20.12.2016.
 */
public class AlbumFacade implements Facade<Album>{

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();

    public void persist(Album album) {
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
    }

    public void merge(Album album) {
        em.getTransaction().begin();
        em.merge(album);
        em.getTransaction().commit();
    }

    public void remove(Album album) {

    }

    public Album find(Album album) {
        return null;
    }


    public void close(){
        em.close();
    }

}
