package hellocucumber;


import hellocucumber.pageObject.Login;
import hellocucumber.pageObject.Product;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class SouceDemo {

//    @FindBy(css = "#user-name")
//    private WebElement userInput;
//
    @FindBy(css = "#password")
    private WebElement passwordInput;

    public void Verificar_el_titulo(){
        // inicialixo el driver de chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // voy a ala URL xxx
        driver.get("https://www.saucedemo.com/");
        // llamo a Login para iniciar sesion
        Login login = new Login(driver);
        login.login("standard_user", "secret_sauce");
        // llamo a la pagina productos para obtener el titulo
        Product productpage = new Product(driver);
        Boolean logo = productpage.isLogoDisplayed();
        String titleString  = productpage.getTitle();
        // verifi el titulo
        Assertions.assertEquals("PRODUCTS", titleString, "The title is not equals");
        ///////////
        Assertions.assertEquals(true, logo, "The logo is not displayed");
        driver.quit();
    }

    public void Add_item_to_theCard(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Login login = new Login(driver);
        Product product = new Product(driver);
        login.login("standard_user", "secret_sauce");
        product.addCart("Fleece Jacket");
        product.addCart("Sauce Labs Onesie");
        String numberItem = product.getNumberItemsAddedCart();
        Assertions.assertEquals("2", numberItem, "The item is not added");
//        driver.quit();
    }

    public static void main(String[] arg){
        SouceDemo sd = new SouceDemo();
        sd.Add_item_to_theCard();
    }

}
