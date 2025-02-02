package models.song;

import models.user.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Playlist {
    private UUID id;
    private String title;
    private User owner;
    private Songs songs = new Songs();

    public Playlist(String title, User owner){
        Objects.requireNonNull(title, "Title can't be null.");
        Objects.requireNonNull(owner, "Owner can't be null.");

        if(title.isEmpty()){
            throw new IllegalArgumentException("Playlist title can't be null.");
        }

        this.id = UUID.randomUUID();
        this.title = title;
        this.owner = owner;
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

    public HashSet<Song> getSongs(){
        return this.songs.getSongs();
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", owner=" + owner.getUsername() +
                ", songs=" + this.songs.getSongs().stream().map(Song::getTitle).toList() +
                '}';
    }
}
