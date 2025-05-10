package servicos;

import modelo.Usuario;
import java.util.LinkedHashMap;

public class ServicoUsuario {
    private final LinkedHashMap<String, Usuario> usuarios = new LinkedHashMap<>();

    public void adicionar(Usuario usuario){
        if(usuario.getNome().isEmpty()){
            throw new IllegalArgumentException("Nome é um campo obrigatório.");
        }

        if(usuario.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username é um campo obrigatório.");
        }

        boolean existeUsuarioComEsseUserName = this.usuarios.containsKey(usuario.getUsername());

        if(existeUsuarioComEsseUserName){
            throw new IllegalArgumentException("Já existe um usuário com esse username.");
        }

        this.usuarios.put(usuario.getUsername(), usuario);
    }

    public void remover(Usuario usuario){
        this.usuarios.remove(usuario.getUsername());
    }

    public Usuario buscarUsuarioPorUsername(String username){
        return this.usuarios.get(username);
    }

    public LinkedHashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
