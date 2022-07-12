package hellocucumber.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {
    private WebDriver driver;


    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
    }

    public String getTitle() {
         return driver.findElement(By.xpath("//span[@class='title']")).getText();
    }
}
