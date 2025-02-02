package service;

import models.artist.Artist;
import models.song.Album;
import models.song.Song;

import java.time.LocalDate;

public class AlbumService {
    public static Album createAlbum(String title, Artist artist, LocalDate releaseDate){
        try{
            return new Album(title, artist, releaseDate);
        }catch (Exception e) {
            System.out.println("Error creating album: " + e.getMessage());
            return null;
        }
    }

    public static void addSong(Album album, Song song){
        try{
            album.addSong(song);
        }catch (Exception e){
            System.out.println("Failed to add song to the album: " + e.getMessage());
        }
    }
}
