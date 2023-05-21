package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By loginPageAssertion = By.xpath("//h2[text()='Welcome Back!']");
    private final By emailTxt = By.id("CustomerEmail");
    private final By passwordTxt = By.id("CustomerPassword");
    private final By loginButton = By.xpath("//input[@value='Log In']");
    private final By assertionMessage = By.xpath("//h1[@class='account__name']");


    public String getLoginPageAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(loginPageAssertion).getText();
    }

    public void enterLoginInformation(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(loginButton).click();
    }

    public String getSuccessfulLoginAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }

}
