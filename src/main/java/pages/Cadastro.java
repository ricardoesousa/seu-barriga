package pages;

import hooks.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cadastro extends BaseTest {

    @FindBy(css="#nome")
    private WebElement txtNome;

    @FindBy(css="#email")
    private WebElement txtEmail;

    @FindBy(css="#senha")
    private WebElement txtSenha;

    @FindBy(css="input[type='submit']")
    private WebElement btnCadastrar;

    public void preencheFormulario(String nome, String email, String senha) {
        txtNome.sendKeys(nome);
        txtEmail.sendKeys(email);
        txtSenha.sendKeys(senha);
    }

    public void salvaCadastro() {
        btnCadastrar.click();
    }

}
