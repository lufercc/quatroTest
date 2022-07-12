package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hello {

    public static void main(String[] arg) {
//        System.setProperty("webdriver.chrome.driver","./src/driver/chr");
//        WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        driver.quit();
    }
}
