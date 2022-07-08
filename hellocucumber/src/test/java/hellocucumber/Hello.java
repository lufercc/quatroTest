package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hello {
    public static void main(String[] arg) {
        System.setProperty("webdriver.chrome.driver","./src/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        driver.quit();
    }
}
