package modelo;

public class Pessoa {
    private final String nome;
    private final String username;

    public Pessoa(String nome, String username) {
        this.nome = nome;
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "nome: " + nome + ", username: " + username;
    }
}
