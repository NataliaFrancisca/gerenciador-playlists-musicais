package modelo;

public class Artista extends Pessoa {
    private final String descricao;

    public Artista(String nome, String username, String descricao){
        super(nome, username);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Artista: " + this.getNome() + ", Descrição: " + descricao;
    }
}
