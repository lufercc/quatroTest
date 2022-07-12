package hellocucumber.pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usrInput;

    @FindBy(css = "#password")
    private WebElement pwInput;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String usr, String pwd){
        usrInput.sendKeys(usr);
        pwInput.sendKeys(pwd);
        loginButton.click();
    }
}
