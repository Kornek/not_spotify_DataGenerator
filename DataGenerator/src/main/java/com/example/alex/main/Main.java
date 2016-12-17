package com.example.alex.main;

import com.example.alex.controller.Controller;
import com.example.alex.facade.SongsFacade;

import java.io.File;

/**
 * Created by Alex on 16.12.2016.
 */
public class Main {
    static Controller c = new Controller();
    public static void main(String[] args) {
        c.readMusic(new File("C:\\Users\\Alex\\Desktop\\Music"));
    }
}
