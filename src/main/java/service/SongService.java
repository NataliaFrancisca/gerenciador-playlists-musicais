package service;

import models.artist.Artist;
import models.song.Song;

import java.util.List;

public class SongService {
    public static Song create(String title, double duration){
        try{
            return new Song(title, duration);
        }catch (Exception e){
            System.out.println("Error creating song: " + e.getMessage());
            return null;
        }
    }

    public static void setArtist(Song song, Artist artist){
        try{
            song.setArtist(artist);
        }catch (Exception e){
            System.out.println("Failed to add artist to the song: " + e.getMessage());
        }
    }

    public static void setArtist(Song song, List<Artist> artist){
        try{
            artist.forEach(song::setArtist);
        }catch (Exception e){
            System.out.println("Failed to add artist to the song: " + e.getMessage());
        }
    }
}
