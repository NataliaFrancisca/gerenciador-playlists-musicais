package models.song;

import models.artist.Artist;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;

public class Song {
    private UUID id;
    private String title;
    private LinkedHashSet<Artist> artists;
    private double duration;

    public Song(String title, double duration){
        Objects.requireNonNull(title, "Title can't be null.");

        if(title.isEmpty()){
            throw new IllegalArgumentException("Title can't be empty.");
        }

        if(duration <= 1){
            throw new IllegalArgumentException("Song size can't be smaller than one");
        }

        this.id =  UUID.randomUUID();
        this.title = title;
        this.duration = duration;
        this.artists = new LinkedHashSet<>();
    }

    public void setArtist(Artist artist){
        Objects.requireNonNull(artist, "Artist can't be empty");

        if(this.artists.contains(artist)){
            throw new RuntimeException("This artist is already set on this song.");
        }

        this.artists.add(artist);
    }

    public UUID getId() {
        return id;
    }

    public LinkedHashSet<Artist> getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artists=" + artists.stream().map(Artist::getName).toList() +
                ", size=" + duration +
                '}';
    }
}
