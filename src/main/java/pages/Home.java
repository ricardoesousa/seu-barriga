package pages;

import hooks.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;

public class Home extends BaseTest {

    @FindBy(css="div.alert.alert-success")
    private WebElement msgBemVindo;

    public boolean validaEntrada(String valEntrada) {
        String txtBemVindo = msgBemVindo.getText();
        assertEquals(valEntrada, txtBemVindo);
        return true;
    }

}

