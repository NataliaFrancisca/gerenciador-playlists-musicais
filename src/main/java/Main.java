import models.artist.Artist;
import models.song.Album;
import models.song.Playlist;
import models.song.Song;
import models.user.User;
import service.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // creating users
        User natalia = UserService.create("Natalia Francisca", "natfrancisca");
        User luiz = UserService.create("Luiz Henrique", "luizxxx");

        // creating artists
        Artist bk = ArtistService.create(
                    "BK",
                    "BK' é um dos principais rappers brasileiros, conhecido por suas letras impactantes sobre racismo, desigualdade e identidade.");

        Artist djavan = ArtistService.create(
                "Djavan",
                "Djavan é um cantor e compositor brasileiro que mistura MPB, jazz e ritmos africanos em suas canções marcantes."
        );

        Artist badbunny = ArtistService.create(
           "Bad Bunny",
           "Bad Bunny é um cantor porto-riquenho que revolucionou o reggaeton e a música latina com seu estilo inovador."
        );

        Artist duquesa = ArtistService.create(
            "Duquesa",
            "Duquesa é uma rapper baiana que mistura rap, trap e R&B, destacando-se com os álbuns Taurus e Taurus, Vol. 2."
        );

        // creating songs & setting artists to the song
        Song songA = SongService.create("VeLDÁ", 3.55);
        Song songB = SongService.create("Fuso", 1.54);
        Song songC = SongService.create("Turma da Duq", 2.13);
        Song songD = SongService.create("Só Eu Sei", 3.40);
        Song songE = SongService.create("Só Quero Ver", 2.49);

        SongService.setArtist(songA, badbunny);
        SongService.setArtist(songB, duquesa);
        SongService.setArtist(songC, duquesa);
        SongService.setArtist(songD, Arrays.asList(bk, djavan));
        SongService.setArtist(songE, bk);

        // creating an album
        Album bkAlbum = AlbumService.createAlbum("Diamantes, Lágrimas, e Rostos para Esquecer", bk, LocalDate.of(2025, 1, 28));
        AlbumService.addSong(bkAlbum, songD);
        AlbumService.addSong(bkAlbum, songE);

        // creating playlists & setting songs to these playlists
        Playlist a = PlaylistService.create("brasil é top", natalia);
        Playlist b = PlaylistService.create("arrumar a casa", luiz);
        Playlist c = PlaylistService.create("duquesa top e o resto nada", natalia);

        PlaylistService.addSong(a, Arrays.asList(songB, songC, songD, songE));
        PlaylistService.addSong(b, Arrays.asList(songB, songA, songC));
        PlaylistService.addSong(c, songB);
        PlaylistService.addSong(c, songC);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
