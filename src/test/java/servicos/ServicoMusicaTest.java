package servicos;

import modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoMusicaTest {
    @InjectMocks
    private ServicoMusica servicoMusica;

    private final Colecao colecao = new Playlist(0, "Don't cry baby", new Usuario("Natalia", "ntfrancisca"));
    private final Artista artista = new Artista("Gigi Perez", "gigiperez", "gigi is one of the best artists");

    @Test
    @DisplayName("Deve lançar uma exceção quando os campos não forem preenchidos.")
    public void deveLancarUmaExcecaoQuandoOsCamposNaoForemPreenchido(){
        Musica musica = new Musica(0, "", 5.03);
        musica.atribuirArtista(this.artista);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoMusica.adicionarMusica(musica, this.colecao));
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando uma música não tem nenhum artista atribuido.")
    public void deveLancarUmaExcecaoQuandoUmaMusicaNaoArtistaAtribuido(){
        Musica musica = new Musica(0, "i am not who i was", 2.25);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoMusica.adicionarMusica(musica, this.colecao));
    }

    @Test
    @DisplayName("Deve atualizar a lista de músicas da coleção depois de adicionar uma música.")
    public void deveAtualizarListaMusicaDaColecaoAposAdicionarUmaMusica(){
        Musica musica = new Musica(0, "Nothing, absolute", 3.45);
        musica.atribuirArtista(this.artista);

        this.servicoMusica.adicionarMusica(musica, this.colecao);
        Assertions.assertEquals(1, this.colecao.getMusicasTitulo().size());
    }

    @Test
    @DisplayName("Deve atualizar a lista de músicas da coleção depois de remover uma música.")
    public void deveAtualizarListaMusicaDaColecaoAposRemoverUmaMusica(){
        Musica musica = new Musica(0, "i am not who i was", 2.25);
        musica.atribuirArtista(this.artista);

        this.servicoMusica.adicionarMusica(musica, this.colecao);
        this.servicoMusica.removerMusica(musica, this.colecao);
        Assertions.assertEquals(0, this.colecao.getMusicasTitulo().size());

    }
}