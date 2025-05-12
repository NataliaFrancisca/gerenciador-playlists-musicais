package servicos;

import modelo.Pessoa;
import modelo.Usuario;
import java.util.LinkedHashMap;

public class ServicoUsuario extends ServicoPessoa {

    public void adicionar(Usuario usuario){
        super.adicionar(usuario);
    }

    public LinkedHashMap<String, Pessoa> getUsuarios(){
        return super.pessoas;
    }

    public Usuario buscarUsuarioPorUsername(String username){
        return (Usuario) this.pessoas.get(username);
    }
}
