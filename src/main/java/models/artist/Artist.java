package models.artist;

import java.util.Objects;
import java.util.UUID;

public class Artist {
    private UUID id;
    private String name;
    private String about;

    public Artist(String name, String about){
        Objects.requireNonNull(name, "Name must not be null.");
        Objects.requireNonNull(about, "About must not be null.");

        if(name.isEmpty()){
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(about.isEmpty()){
            throw new IllegalArgumentException("About can't be empty");
        }

        this.id = UUID.randomUUID();
        this.name = name;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
