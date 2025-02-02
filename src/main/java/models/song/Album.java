package models.song;

import models.artist.Artist;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Album{
    private UUID id;
    private Songs songs = new Songs();
    private String title;
    private Artist artist;
    private LocalDate releaseDate;

    public Album(String title, Artist artist, LocalDate releaseDate) {
        Objects.requireNonNull(title, "Title can't be null.");
        Objects.requireNonNull(artist, "Artist can't be null.");
        Objects.requireNonNull(releaseDate, "Release data can't be null.");

        if(title.isEmpty()){
            throw new IllegalArgumentException("Title can't be empty.");
        }

        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }

    public void addSong(Song song){
        this.songs.addSong(song);
    }

    public void removeSong(Song song){
        this.songs.removeSong(song);
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public HashSet<Song> getSongs() {
        return this.songs.getSongs();
    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
