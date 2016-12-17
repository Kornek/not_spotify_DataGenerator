package com.example.alex.controller;

import com.example.alex.entity.Song;
import com.example.alex.facade.SongsFacade;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Alex on 16.12.2016.
 */
public class Controller {

    SongsFacade songsFacade = new SongsFacade();

    public Controller() {
        songsFacade.em = Persistence.createEntityManagerFactory("myPU").createEntityManager();
    }

    public void readMusic(File folder) {
        System.out.println(folder.getPath());
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readMusic(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                Mp3File mp3file = null;
                try {
                    mp3file = new Mp3File(fileEntry);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedTagException e) {
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }
                if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    System.out.println("Track: " + id3v1Tag.getTrack());
                    System.out.println("Artist: " + id3v1Tag.getArtist());
                    System.out.println("Title: " + id3v1Tag.getTitle());
                    System.out.println("Album: " + id3v1Tag.getAlbum());
                    System.out.println("Year: " + id3v1Tag.getYear());
                    System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
                    System.out.println("Comment: " + id3v1Tag.getComment());
                    System.out.printf("\n");

                    try {
                        Song song = new Song(id3v1Tag.getTitle(), Files.readAllBytes(Paths.get(fileEntry.getAbsolutePath())),Long.parseLong(id3v1Tag.getTrack()));
                        System.out.println(song.getSongfile());
                        songsFacade.save(song);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

    }

}
