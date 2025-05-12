package dto;

import modelo.Musica;


public class MusicaDTO {

    public static String musicaParaPlaylist(Musica musica){
        return "%s - %s".formatted(musica.getTitulo(), musica.getArtistas());
    }

    public static String musicaParaAlbum(Musica musica){
        return "%s".formatted(musica.getTitulo());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
