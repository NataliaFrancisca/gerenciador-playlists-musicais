package service;

import models.song.Playlist;
import models.song.Song;
import models.user.User;

import java.util.List;

public class PlaylistService {
     public static Playlist create(String title, User user){
         try{
             return user.createPlaylist(title);
         }catch (Exception e){
             System.out.println("Failed to create playlist: " + e.getMessage());
             return null;
         }
     }

     public static void addSong(Playlist playlist, Song song){
         try{
             playlist.addSong(song);
         }catch (Exception e){
             System.out.println("Failed to add song to the playlist: " + e.getMessage());
         }
     }

     public static void addSong(Playlist playlist, List<Song> song){
         try{
             song.forEach(playlist::addSong);
         }catch (Exception e){
             System.out.println("Failed to add song to the playlist: " + e.getMessage());
         }
    }
}
