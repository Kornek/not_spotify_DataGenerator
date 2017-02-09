package com.example.alex.facade;

import com.example.alex.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Alex on 16.12.2016.
 */
public class SongFacade implements Facade<Song>{

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();


    public void close(){
        em.close();
    }

    public void persist(Song song) {
        em.getTransaction().begin();
        em.persist(song);
        em.getTransaction().commit();
    }

    public void merge(Song song) {
        em.getTransaction().begin();
        em.merge(song);
        em.getTransaction().commit();
    }

    public void remove(Song song) {

    }

    public Song find(Song song) {
        return null;
    }

    public Song getRandomSong(){
        Query countQuery = em.createNativeQuery("select count(*) from SONGS");
        BigDecimal count = (BigDecimal) countQuery.getSingleResult();

        Random random = new Random();
        int number = random.nextInt(count.intValue());

        Query selectQuery = em.createQuery("select u from Song u");
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);
        return (Song) selectQuery.getSingleResult();
    }
}
