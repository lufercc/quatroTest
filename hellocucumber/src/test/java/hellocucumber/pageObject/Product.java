package hellocucumber.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
    private WebDriver driver;

    private static String ADD_CARD_BUTTON = "//div[contains(text(),'_ITEM_NAME')]//ancestor::div[@class = 'inventory_item_description']/div[@class='pricebar']/button";

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement logoItem;

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement numberItemInCart;

    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addCart(String itemName) {
        String locator = ADD_CARD_BUTTON.replace("_ITEM_NAME", itemName);
        WebElement addButton = driver.findElement(By.xpath(locator));
        addButton.click();
    }

    public boolean isLogoDisplayed() {
        return logoItem.isDisplayed();
    }

    public String getTitle() {
         return title.getText();
    }

    public String getNumberItemsAddedCart() {
        return numberItemInCart.getText();
    }
}
