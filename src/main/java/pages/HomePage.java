package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    Actions actions;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By accountManageOptions = By.cssSelector("li.lg-max\\:hidden:nth-child(3) > a:nth-child(1) > svg:nth-child(1)");
    private final By createAccount = By.xpath("//a[text()='Create account']");
    private final By loginButton = By.xpath("//a[@href='/account/login' and text()='Log in']");
    private final By logOutButton = By.xpath("//a[text()='Log out']");
    private final By searchIcon = By.cssSelector("li.lg-max\\:hidden:nth-child(1) > button:nth-child(1) > svg:nth-child(1)");

    public RegisterPage navigateToCreateAccount(){
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(accountManageOptions)).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(createAccount)));
        driver.findElement(createAccount).click();
        return new RegisterPage(driver);
    }

    public LoginPage navigateToLoginPage(){
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(accountManageOptions)).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void logOut(){
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions.moveToElement(driver.findElement(accountManageOptions)).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(logOutButton)));
        driver.findElement(logOutButton).click();
    }

    public SearchPage navigateToSearchPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(searchIcon).click();
        return new SearchPage(driver);
    }
}
