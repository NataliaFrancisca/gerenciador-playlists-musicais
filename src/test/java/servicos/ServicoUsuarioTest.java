package servicos;

import modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoUsuarioTest {
    @InjectMocks
    private ServicoUsuario servicoUsuario;

    @Test
    @DisplayName("Deve lançar uma exceção quando os campos não forem preenchido.")
    public void deveLancarUmaExcecaoQuandoCamposNaoForemPreenchido(){
        Usuario usuario = new Usuario("Natalia", "");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoUsuario.adicionar(usuario));
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o username já foi cadastrado.")
    public void deveLancarUmaExcecaoQuandoUsernameJaFoiCadastrado(){
        Usuario usuarioA = new Usuario( "Natalia", "ntfrancisca");
        Usuario usuarioB = new Usuario("Francisca", "ntfrancisca");

        this.servicoUsuario.adicionar(usuarioA);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoUsuario.adicionar(usuarioB));
    }

    @Test
    @DisplayName("Depois de remover um usuário, deve retornar uma lista vazia.")
    public void deveRetornarUmaListaVazia(){
        Usuario usuario = new Usuario("Natalia", "ntfrancisca");

        this.servicoUsuario.adicionar(usuario);
        this.servicoUsuario.remover(usuario);

        Assertions.assertEquals(0, this.servicoUsuario.getUsuarios().size());
    }

    @Test
    @DisplayName("Deve retornar um usuário de acordo com username")
    public void deveRetornarUmUsuarioDeAcordoComUsername(){
        Usuario usuario = new Usuario("Natalia", "ntfrancisca");

        this.servicoUsuario.adicionar(usuario);

        Assertions.assertEquals(usuario, this.servicoUsuario.buscarUsuarioPorUsername("ntfrancisca"));
    }
}