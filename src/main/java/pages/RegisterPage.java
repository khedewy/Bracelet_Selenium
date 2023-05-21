package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    Actions actions;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private final By createAccountPageAssertion = By.xpath("//h1[@class='account__title']");
    private final By firstNameTxt = By.id("FirstName");
    private final By lastNameTxt = By.id("LastName");
    private final By emailTxt = By.id("Email");
    private final By passwordTxt = By.id("CreatePassword");
    private final By signInButton = By.xpath("//input[@class='button button--black button--large']");
    private final By accountManageIcon = By.cssSelector("li.lg-max\\:hidden:nth-child(3) > a:nth-child(1) > svg:nth-child(1)");
    private final By accountInformation = By.xpath("//a[@href='/account' and text()='Account']");
    private final By assertionMessage = By.xpath("//h1[@class='account__name']");

    public String getCreateAccountAssertionMessage(){
        return driver.findElement(createAccountPageAssertion).getText();
    }

    public void enterUserInfo(String firstName, String lastName, String email, String password) throws InterruptedException {

        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,700)");
        Thread.sleep(3000);
        driver.findElement(signInButton).click();
    }

    public void navigateToAccountInf() throws InterruptedException {
        actions = new Actions(driver);
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(accountManageIcon)).perform();
        Thread.sleep(2000);
        driver.findElement(accountInformation).click();
    }

    public String getSuccessfulRegisterMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(assertionMessage).getText();
    }
}
