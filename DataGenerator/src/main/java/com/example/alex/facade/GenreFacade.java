package com.example.alex.facade;

import com.example.alex.entity.Album;
import com.example.alex.entity.Artist;
import com.example.alex.entity.Genre;
import com.example.alex.entity.Song;

import javax.persistence.*;

/**
 * Created by Alex on 01.02.2017.
 */
public class GenreFacade implements Facade<Genre> {

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();

    public void updateGenre(Genre g, Song s) {
        Genre genre = em.find(Genre.class, g.getGenreid());
        Song song = em.find(Song.class, s.getSongid());
        em.getTransaction().begin();
        genre.addGenreSong(song);
        em.getTransaction().commit();
    }

    public Genre getByName(String name) {
        try {
            em.getTransaction().begin();
            TypedQuery<Genre> genreTypedQuery = em.createNamedQuery("Genre.getByName", Genre.class)
                    .setParameter("name", name);
            em.getTransaction().commit();
            return genreTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public void close() {
        em.close();
    }

    public void persist(Genre genre) {
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }

    public void merge(Genre genre) {
        em.getTransaction().begin();
        em.merge(genre);
        em.getTransaction().commit();
    }

    public void remove(Genre genre) {

    }

    public Genre find(Genre genre) {
        return null;
    }
}