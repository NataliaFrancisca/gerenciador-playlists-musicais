package servicos;

import modelo.Artista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoArtistaTest {
    @InjectMocks
    private ServicoArtista servicoArtista;

    @Test
    @DisplayName("Deve lançar uma exceção quando o campo descrição não for preenchido.")
    public void deveLancarUmaExcecaoQuandoCampoDescricaoNaoForPreenchido(){
        Artista artista = new Artista("Duquesa", "duquesa", "");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoArtista.adicionar(artista));
    }

    @Test
    @DisplayName("Deve retornar um artista de acordo com username")
    public void deveRetornarUmUsuarioDeAcordoComUsername(){
        Artista artista = new Artista("Bad Bunny", "badbunny", "Bad Bunny um dos maiores da america latina, vulgo Porto Rico.");

        this.servicoArtista.adicionar(artista);

        Assertions.assertEquals(artista, this.servicoArtista.buscarArtistaPorUsername("badbunny"));
    }
}