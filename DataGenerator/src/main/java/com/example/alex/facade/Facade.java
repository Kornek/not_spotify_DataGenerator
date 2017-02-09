package com.example.alex.facade;

/**
 * Created by Alex on 07.02.2017.
 */
public interface Facade<T> {

    void persist(T entity);
    void merge(T entity);
    void remove(T entity);
    T find(T entity);
    void close();
}
