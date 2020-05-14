package hooks;

import lombok.Getter;
import lombok.Setter;
import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest implements DefaultProperties {

    @Getter @Setter
    private static WebDriver driver;
    DriverManager driverManager;

    @Before
    public void Init() {
        driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(DefaultProperties.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void TearDown() { driver.quit(); }

}

