import hellocucumber.pageObject.Login;
import hellocucumber.pageObject.Product;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SouceSteps {
    Login login;
    Product product;
    WebDriver driver;

    public SouceSteps(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.login = new Login(driver);
        this.product = new Product(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("Abro la pagina {string}")
    public void abroLaPagina(String url) {
        driver.get(url);
    }

    @Given("Me logeo con el usuario {string} y la contraseña {string}")
    public void MeLogeoConElUsuatioYLaContrasena(String usr, String pwd){
        login.login(usr, pwd);
    }

    @Then("Verifico que el titulo sea {string}")
    public void verificoQueElTituloSea(String expTitle) {
        String title = product.getTitle();
        Assertions.assertEquals(expTitle, title);
    }

}
