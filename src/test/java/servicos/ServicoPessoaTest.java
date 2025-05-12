package servicos;

import modelo.Pessoa;
import modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoPessoaTest {
    @InjectMocks
    private ServicoPessoa servicoPessoa;

    @Test
    @DisplayName("Deve lançar uma exceção quando os campos não forem preenchido.")
    public void deveLancarUmaExcecaoQuandoCamposNaoForemPreenchido(){
        Pessoa pessoa = new Usuario("Natalia", "");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoPessoa.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o username já foi cadastrado.")
    public void deveLancarUmaExcecaoQuandoUsernameJaFoiCadastrado(){
        Pessoa pessoaA = new Usuario( "Natalia", "ntfrancisca");
        Pessoa pessoaB = new Usuario("Francisca", "ntfrancisca");

        this.servicoPessoa.adicionar(pessoaA);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.servicoPessoa.adicionar(pessoaB));
    }

    @Test
    @DisplayName("Depois de remover uma pessoa, deve retornar uma lista vazia.")
    public void deveRetornarUmaListaVazia(){
        Pessoa pessoa = new Usuario("Natalia", "ntfrancisca");

        this.servicoPessoa.adicionar(pessoa);
        this.servicoPessoa.remover(pessoa);

        Assertions.assertEquals(0, this.servicoPessoa.getPessoas().size());
    }
}