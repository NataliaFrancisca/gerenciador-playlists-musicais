package servicos;

import modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoColecaoTest {

    @InjectMocks
    private ServicoColecao servicoColecao;

    private final Musica musica = new Musica(0, "North", 3.33);
    private final Artista artista = new Artista("clairo", "clairo", "clairo lovely girl");

    @Test
    @DisplayName("Deve lançar uma exceção quando os campos não forem preenchidos.")
    public void deveLancarUmaExecaoQuandoOsCamposNaoForemPreenchidos(){
        Colecao colecao = new Playlist(0, "", new Usuario("Natalia", "ntfrancisca"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoColecao.adicionar(colecao));
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o id da coleção for inválida.")
    public void deveLancarUmaExcecaoQuandoIdColecaoForInvalido(){
        this.musica.atribuirArtista(artista);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoColecao.adicionarMusica(this.musica, -21));
    }
}