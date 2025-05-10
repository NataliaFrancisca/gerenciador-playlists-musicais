package servicos;

import modelo.Artista;
import modelo.Pessoa;

import java.util.LinkedHashMap;

public class ServicoArtista extends ServicoPessoa{

    public void adicionar(Artista artista){
        if(artista.getDescricao().isEmpty()){
            throw new IllegalArgumentException("Descrição é um campo obrigatório.");
        }
        super.adicionar(artista);
    }

    public LinkedHashMap<String, Pessoa> getArtistas() {
        return super.pessoas;
    }

    public Artista buscarArtistaPorUsername(String username){
        return (Artista) this.pessoas.get(username);
    }
}
