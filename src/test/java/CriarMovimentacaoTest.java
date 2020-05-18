import com.github.javafaker.Faker;
import hooks.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.Locale;

import static org.junit.Assert.*;

public class CriarMovimentacaoTest extends BaseTest {

    @Test
    public void test() {

        Home home = PageFactory.initElements(getDriver(), Home.class);
        NavBar navBar = PageFactory.initElements(getDriver(), NavBar.class);
        Contas contas = PageFactory.initElements(getDriver(), Contas.class);
        Login login = PageFactory.initElements(getDriver(), Login.class);
        Cadastro cadastro = PageFactory.initElements(getDriver(), Cadastro.class);
        Movimentacao movimentacao = PageFactory.initElements(getDriver(), Movimentacao.class);

        Faker faker = new Faker(new Locale("pt-BR"));
        String email = faker.internet().emailAddress();
        String senha = faker.internet().password();
        String nome = faker.name().fullName();
        String conta = faker.name().firstName();
        String valor = faker.number().randomNumber() + "." + faker.number().digits(2);
        String descricao = faker.dragonBall().character();
        String interessado = faker.harryPotter().character();

        login.acessaAplicacao();
        navBar.criaNovoUsuario();
        cadastro.preencheFormulario(nome,email,senha);
        cadastro.salvaCadastro();
        assertTrue(login.validaCadastro("Usuário inserido com sucesso"));
        login.entra(email,senha);
        assertTrue(home.validaEntrada("Bem vindo, " + nome + "!"));
        navBar.criaConta();
        contas.preencheFormulario(conta);
        contas.salvaConta();
        assertTrue(contas.validaConta("Conta adicionada com sucesso!"));
        navBar.criaMovimentacao();
        movimentacao.preencheFormulario("Receita","14/05/2020","30/05/2020"
                ,descricao,interessado,valor,conta,"pago");
        movimentacao.salvaMovimentacao();
        assertTrue(movimentacao.validaMovimentacao("Movimentação adicionada com sucesso!"));
        navBar.sai();
    }

}
