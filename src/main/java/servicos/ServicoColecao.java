package servicos;

import modelo.Colecao;
import modelo.Musica;

import java.util.LinkedHashMap;

public class ServicoColecao extends ServicoMusica {
    private final LinkedHashMap<Long, Colecao> colecoes = new LinkedHashMap<>();

    private Colecao buscarColecao(long colecaoId){
        if(colecaoId < 0){
            throw new IllegalArgumentException("Campo id deve ser um valor positivo.");
        }

        return this.colecoes.get(colecaoId);
    }

    public void adicionar(Colecao colecao){
        if(colecao.getId() < 0){
            throw new IllegalArgumentException("Campo id deve ser um valor positivo.");
        }

        if(colecao.getTitulo().isEmpty()){
            throw new IllegalArgumentException("Campo título é obrigatório.");
        }

        this.colecoes.put(colecao.getId(), colecao);
    }

    public Colecao getColecao(long colecaoId){
        return this.buscarColecao(colecaoId);
    }

    public LinkedHashMap<Long, Colecao> getColecoes() {
        return colecoes;
    }

    public void adicionarMusica(Musica musica, long colecaoId){
        Colecao colecao = this.buscarColecao(colecaoId);
        super.adicionarMusica(musica, colecao);
    }

    public void removerMusica(Musica musica, long colecaoId){
        Colecao colecao = this.buscarColecao(colecaoId);
        super.removerMusica(musica, colecao);
    }
}
