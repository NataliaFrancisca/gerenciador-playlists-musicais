package modelo;

import java.util.ArrayList;
import java.util.List;

public class Musica {
    private final long id;
    private final String titulo;
    private final double duracao;
    private final List<String> artistas;

    public Musica(long id, String titulo, double duracao){
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.artistas = new ArrayList<>();
    }

    public void atribuirArtista(Artista artista){
        this.artistas.add(artista.getNome());
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public List<String> getArtistas() {
        return artistas;
    }

    @Override
    public String toString() {
       return "Titulo: " + titulo;
    }
}
