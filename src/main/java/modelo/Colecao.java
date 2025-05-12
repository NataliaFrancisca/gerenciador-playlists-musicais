package modelo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Colecao {
    private final long id;
    private final String titulo;
    private final Set<Musica> musicas;

    public Colecao(long id, String titulo){
        this.id = id;
        this.titulo = titulo;
        this.musicas = new HashSet<>();
    }

    public void adicionarMusica(Musica musica){
        this.musicas.add(musica);
    }

    public void removerMusica(Musica musica){
        this.musicas.remove(musica);
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Set<Musica> getMusicas(){
        return this.musicas;
    }

    public Set<String> getMusicasTitulo() {
        return this.musicas.stream().map(Musica::getTitulo).collect(Collectors.toSet());
    }
}
