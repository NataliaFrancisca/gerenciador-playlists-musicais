package modelo;

import dto.MusicaDTO;

import java.util.List;

public class Playlist extends Colecao {
    private final Usuario usuario;

    public Playlist(long id, String titulo, Usuario usuario){
        super(id, titulo);
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        List<String> musicas = this.getMusicas().stream().map(MusicaDTO::musicaParaPlaylist).toList();

        return """
                Playlist: %s
                Criador: %s
                Musicas: %s
                """.formatted(getTitulo(), this.usuario.getUsername(), musicas);
    }
}
