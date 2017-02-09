package com.example.alex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "GENRES")
@NamedQueries({
        @NamedQuery(
                name="Genre.getByName",
                query="Select g From Genre g Where lower(g.genrename) = lower(:name)"
        )

})
public class Genre {
    @Id
    @SequenceGenerator(name = "genreSeq", sequenceName = "GENREID_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genreSeq")
    @Column(name = "GENREID")
    private long genreid;

    private String genrename;

    @OneToMany(mappedBy="songGenre" , cascade = CascadeType.PERSIST)
    private List<Song> genreSongs = new ArrayList<Song>();

    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }

    public long getGenreid() {
        return genreid;
    }

    public void setGenreid(long genreid) {
        this.genreid = genreid;
    }

    public List<Song> getGenreSongs() {
        return genreSongs;
    }

    public void setGenreSongs(List<Song> genreSongs) {
        this.genreSongs = genreSongs;
    }

    public void addGenreSong(Song song){
        if (!getGenreSongs().contains(song)) {
            genreSongs.add(song);
            System.out.println("song added");
        }
        if(song.getSongGenre() != this){
            System.out.println("rucursion");
            song.setSongGenre(this);

        }
    }
}
