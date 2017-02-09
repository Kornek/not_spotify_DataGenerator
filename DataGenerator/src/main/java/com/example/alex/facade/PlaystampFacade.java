package com.example.alex.facade;

import com.example.alex.entity.Playstamp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Alex on 08.02.2017.
 */
public class PlaystampFacade implements Facade<Playstamp> {
    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();

    public void persist(Playstamp playstamp) {
        em.getTransaction().begin();
        em.persist(playstamp);
        em.getTransaction().commit();
    }

    public void merge(Playstamp playstamp) {

    }

    public void remove(Playstamp playstamp) {

    }

    public Playstamp find(Playstamp playstamp) {
        return null;
    }

    public void close() {
        em.close();
    }
}
