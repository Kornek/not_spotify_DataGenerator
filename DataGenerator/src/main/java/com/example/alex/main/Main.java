package com.example.alex.main;

import com.example.alex.controller.Controller;

/**
 * Created by Alex on 16.12.2016.
 */
public class Main {
    static Controller c = new Controller();
    public static void main(String[] args) {
        //c.persistGenres();
        //c.readMusic(new File("C:\\Users\\Alex\\Desktop\\Musi"));
        //c.createUsers();
        c.generateClicks();
        c.close();

    }
}
