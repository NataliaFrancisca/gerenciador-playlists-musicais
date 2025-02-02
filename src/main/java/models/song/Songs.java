package models.song;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Songs {
    private LinkedHashSet<Song> songs;

    public Songs(){
        this.songs = new LinkedHashSet<>();
    }

    protected void addSong(Song song){
        Objects.requireNonNull(song, "song can't be empty.");

        if(this.songs.contains(song)){
            throw new RuntimeException("This song is already on this album.");
        }

        this.songs.add(song);
    }

    protected void removeSong(Song song){
        Objects.requireNonNull(song, "song can't be empty");

        if(!this.songs.contains(song)){
            throw new RuntimeException("This song don't exist on this album.");
        }

        this.songs.removeIf(songIf -> songIf.getId().equals(song.getId()));
    }

    protected LinkedHashSet<Song> getSongs(){
        return this.songs;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songs=" + songs.stream().map(Song::getTitle).toList() +
                '}';
    }
}
