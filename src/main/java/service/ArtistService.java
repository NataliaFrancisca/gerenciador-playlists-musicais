package service;

import models.artist.Artist;

public class ArtistService {
    public static Artist create(String name, String about){
        try{
            return new Artist(name, about);
        }catch (Exception e){
            System.out.println("Failed to register artist: " + e.getMessage());
            return null;
        }
    }
}
