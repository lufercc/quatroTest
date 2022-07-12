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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Login login = new Login(driver);
        login.login("standard_user", "secret_sauce");
        Product productpage = new Product(driver);
        Boolean logo = productpage.isLogoDisplayed();
        String titleString  = productpage.getTitle();
        Assertions.assertEquals("PRODUCTS", titleString, "The title is not equals");
        Assertions.assertEquals(true, logo, "The logo is not displayed");
        driver.quit();
    }

    public void Add_item_to_theCard(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Login login = new Login(driver);
        login.login("standard_user", "secret_sauce");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        String numberItem = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assertions.assertEquals("1", numberItem, "The item is not added");
//        driver.quit();
    }

    public static void main(String[] arg){
        SouceDemo sd = new SouceDemo();
        sd.Verificar_el_titulo();
    }

}
