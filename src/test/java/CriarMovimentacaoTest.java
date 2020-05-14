import hooks.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.*;

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

        login.acessaAplicacao();
        navBar.criaNovoUsuario();
        cadastro.preencheFormulario("Teste","teste2000@gft.com","123456");
        cadastro.salvaCadastro();
        assertTrue(login.validaCadastro("Usuário inserido com sucesso"));
        login.entra("teste2000@gft.com","123456");
        assertTrue(home.validaEntrada("Bem vindo, Teste!"));
        navBar.criaConta();
        contas.preencheFormulario("Teste");
        contas.salvaConta();
        assertTrue(contas.validaConta("Conta adicionada com sucesso!"));
        navBar.criaMovimentacao();
        movimentacao.preencheFormulario("Despesa","14/05/2020","30/05/2020"
                ,"Teste","Teste","13.00","Teste","pago");
        movimentacao.salvaMovimentacao();
        assertTrue(movimentacao.validaMovimentacao("Movimentação adicionada com sucesso!"));
        navBar.sai();
    }

}
