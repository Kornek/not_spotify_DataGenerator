package com.example.alex.facade;

import com.example.alex.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Alex on 08.02.2017.
 */
public class UserFacade implements Facade<User>{

    private EntityManager em = Persistence.createEntityManagerFactory("myPU").createEntityManager();

    public void persist(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void merge(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void remove(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public User find(User user) {
        em.getTransaction().begin();
        em.find(User.class,user.getUserid());
        em.getTransaction().commit();
        return null;
    }

    public void close() {
        em.close();
    }

    public User getRandomUser(){
        Query countQuery = em.createNativeQuery("select count(*) from USERS");
        BigDecimal count = (BigDecimal) countQuery.getSingleResult();

        Random random = new Random();
        int number = random.nextInt(count.intValue());

        Query selectQuery = em.createQuery("select u from User u");
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);
        return (User) selectQuery.getSingleResult();
    }
}
