package models.user;

import models.song.Playlist;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String username;

    public User(String name, String username){
        Objects.requireNonNull(name, "Name can't be null.");
        Objects.requireNonNull(username, "Username can't be null.");

        if(name.isEmpty()){
            throw new IllegalArgumentException("Name can't be empty.");
        }

        if(username.isEmpty()){
            throw new IllegalArgumentException("Username can't be empty.");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.username = username;
    }

    public Playlist createPlaylist(String title){
        Objects.requireNonNull(title);

        if(title.isEmpty()){
            throw new IllegalArgumentException("Playlist title can't be empty");
        }

        return new Playlist(title, this);
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
}
