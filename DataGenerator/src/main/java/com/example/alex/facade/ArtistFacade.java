package com.example.alex.facade;

import com.example.alex.entity.Album;
import com.example.alex.entity.Artist;
import com.example.alex.entity.Genre;
import com.example.alex.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by Alex on 21.12.2016.
 */
public class ArtistFacade implements Facade<Artist>{

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();


    public void updateArtist(Artist a, Song song ){
        Artist artist = em.find(Artist.class, a.getArtistid());
        em.getTransaction().begin();
        artist.addArtistSong(song);
        em.getTransaction().commit();
    }

    public void close(){
        em.close();
    }

    public void persist(Artist artist) {
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
    }

    public void merge(Artist artist) {
        em.getTransaction().begin();
        em.merge(artist);
        em.getTransaction().commit();
    }

    public void remove(Artist artist) {

    }

    public Artist find(Artist artist) {
        return null;
    }
}
