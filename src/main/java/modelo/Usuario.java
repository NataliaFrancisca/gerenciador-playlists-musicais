package modelo;

public class Usuario extends Pessoa {
    public Usuario(String nome, String username) {
        super(nome, username);
    }

    @Override
    public String toString() {
        return "nome: " + this.getNome() + ", username: " + this.getUsername();
    }
}
