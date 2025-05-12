package modelo;

import dto.MusicaDTO;

import java.time.LocalDate;
import java.util.List;

public class Album extends Colecao {
    private final LocalDate dataLancamento;
    private final Artista artista;

    public Album(long id, String titulo, LocalDate dataLancamento, Artista artista){
        super(id, titulo);
        this.dataLancamento = dataLancamento;
        this.artista = artista;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        List<String> musicas = this.getMusicas().stream().map(MusicaDTO::musicaParaAlbum).toList();

        return """
                Título: %s
                Artista: %s
                Lançamento: %s
                Músicas: %s
                """.formatted(getTitulo(), getArtista().getNome(), getDataLancamento(), musicas);
    }
}
