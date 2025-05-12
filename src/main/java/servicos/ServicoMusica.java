package servicos;

import modelo.Colecao;
import modelo.Musica;

public class ServicoMusica {

    private void validarMusica(Musica musica){
        if(musica.getTitulo().isEmpty()){
            throw new IllegalArgumentException("Campo título é obrigatório.");
        }

        if(musica.getDuracao() < 0.10){
            throw new IllegalArgumentException("Campo duração deve ter um valor maior ou igual a 10");
        }

        if(musica.getId() < 0){
            throw new IllegalArgumentException("Campo id deve ser um valor positivo.");
        }

        if(musica.getArtistas().isEmpty()){
            throw new IllegalArgumentException("Campo artista deve ser atribuido.");
        }
    }

    protected void adicionarMusica(Musica musica, Colecao colecao){
        this.validarMusica(musica);

        if(colecao.getMusicas().contains(musica)){
            throw new IllegalArgumentException("Essa música já existe na coleção.");
        }

        colecao.adicionarMusica(musica);
    }

    protected void removerMusica(Musica musica, Colecao colecao){
        if(!colecao.getMusicas().contains(musica)){
            throw new IllegalArgumentException("Não existe essa música na coleção");
        }

        colecao.removerMusica(musica);
    }
}
