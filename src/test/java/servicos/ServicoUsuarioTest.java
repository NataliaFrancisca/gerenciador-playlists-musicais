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
    @DisplayName("Deve retornar um usuário de acordo com username")
    public void deveRetornarUmUsuarioDeAcordoComUsername(){
        Usuario usuario = new Usuario("Natalia", "ntfrancisca");

        this.servicoUsuario.adicionar(usuario);

        Assertions.assertEquals(usuario, this.servicoUsuario.buscarUsuarioPorUsername("ntfrancisca"));
    }
}