package com.example.alex.controller;

import com.example.alex.entity.*;
import com.example.alex.facade.*;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Alex on 16.12.2016.
 */
public class Controller {

    SongFacade songFacade = new SongFacade();
    AlbumFacade albumFacade = new AlbumFacade();
    ArtistFacade artistFacade = new ArtistFacade();
    GenreFacade genreFacade = new GenreFacade();
    UserFacade userFacade = new UserFacade();
    PlaystampFacade playstampFacade = new PlaystampFacade();

    public Controller() {

    }

    public void readMusic(File folder) {
        System.out.println(folder.getPath());

        Artist artist = new Artist("Rise Against");
        artistFacade.persist(artist);
        Album album = new Album("Endgame");
        Genre genre = genreFacade.getByName("Punk rock");
        album.setAlbumArtist(artist);
        albumFacade.persist(album);

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                readMusic(fileEntry);
            } else {
                Mp3File mp3file = null;
                try {
                    if (fileEntry.getName()
                            .substring(
                                    fileEntry.getName().length() - 3,
                                    fileEntry.getName().length()).equals("mp3")) {
                        mp3file = new Mp3File(fileEntry);
                        if (mp3file.hasId3v1Tag()) {
                            ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                            System.out.println("Track: " + id3v1Tag.getTrack());
                            System.out.println("Artist: " + id3v1Tag.getArtist());
                            System.out.println("Title: " + id3v1Tag.getTitle());
                            System.out.println("Album: " + id3v1Tag.getAlbum());
                            System.out.println("Year: " + id3v1Tag.getYear());
                            System.out.println("Genre: " + id3v1Tag.getGenre());
                            System.out.println("Comment: " + id3v1Tag.getComment());
                            System.out.printf("\n");

                            try {
                                Song song = new Song(id3v1Tag.getTitle(), Files.readAllBytes(Paths.get(fileEntry.getAbsolutePath())), Long.parseLong(id3v1Tag.getTrack()));
                                song.setSongAlbum(album);
                                song.setSongArtist(artist);
                                song.setSongGenre(genre);
                                //album.addAlbumSong(song);
                                //artist.addArtistSong(song);
                                //genre.addGenreSong(song);
                                songFacade.persist(song);
                                //albumFacade.merge(album);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (UnsupportedTagException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void persistGenres() {
        List<String> genres = Arrays.asList("Alternative rock", "Hard rock", "Heavy metal", "Nu metal", "Metalcore",
                "Folk metal", "Punk rock");
        for (String s :
                genres) {
            Genre genre = new Genre();
            genre.setGenrename(s);
            genreFacade.persist(genre);
        }
    }

    public void createUsers() {
        for (int i = 1; i < 10; i++) {
            User u = new User();
            u.setUsername("test" + i);
            u.setEmail("test" + i + "@gmail.com");
            u.setPassword("passme" + i);
            u.setFirstname("Dango");
            u.setLastname("Hundenberger");
            userFacade.persist(u);
        }

    }

    public void generateClicks() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            User u = userFacade.getRandomUser();
            int number = r.nextInt(100);
            for (int j = 0; j < number; j++) {
                Playstamp ps = new Playstamp();
                ps.setPlaystampUser(u);
                ps.setPlaystampSong(songFacade.getRandomSong());
                ps.setPlayed(java.sql.Timestamp.valueOf(LocalDateTime.now()));
                playstampFacade.persist(ps);
            }
        }

    }

    public void close() {
        songFacade.close();
        albumFacade.close();
        artistFacade.close();
        genreFacade.close();
    }
}
