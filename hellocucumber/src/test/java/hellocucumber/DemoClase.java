package hellocucumber;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoClase {

    public static void main(String[] arg) throws InterruptedException {
        testUno();
    }
    public static void testUno() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        //ingresando a la pagina
        driver.get("https://www.saucedemo.com/");
        // cargando credenciales
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //presionando login
        driver.findElement(By.id("login-button")).click();
        // validando titulo
        String titulo = driver.findElement(By.className("title")).getText();
        // añadiendo a carrito
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assertions.assertEquals("PRODUCTS",titulo.toUpperCase());
        Thread.sleep(3000);
        driver.quit();
    }
}
