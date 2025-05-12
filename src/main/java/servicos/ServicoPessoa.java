package servicos;

import modelo.Pessoa;

import java.util.LinkedHashMap;

public class ServicoPessoa {
    protected final LinkedHashMap<String, Pessoa> pessoas = new LinkedHashMap<>();

    public void adicionar(Pessoa pessoa){
        if(pessoa.getNome().isEmpty()){
            throw new IllegalArgumentException("Nome é um campo obrigatório.");
        }

        if(pessoa.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username é um campo obrigatório.");
        }

        boolean existeUsuarioComEsseUserName = this.pessoas.containsKey(pessoa.getUsername());

        if(existeUsuarioComEsseUserName){
            throw new IllegalArgumentException("Já existe cadastro com esse username.");
        }

        this.pessoas.put(pessoa.getUsername(), pessoa);
    }

    public void remover(Pessoa pessoa){
        this.pessoas.remove(pessoa.getUsername());
    }

    public LinkedHashMap<String, Pessoa> getPessoas() {
        return pessoas;
    }
}
