package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    private final WebDriver driver;
    Actions actions;
    public ShopPage(WebDriver driver){
        this.driver = driver;
    }
    private final By shopOptions = By.id("desktop-nav-shop");
    private final By ringsProduct = By.id("desktop-nav-shop-jewelry-rings");
    private final By firstProductAssertion = By.xpath("//li[text()='Rings']");
    private final By engravables = By.id("desktop-nav-shop-jewelry-engravables");
    private final By engravablesAssertion = By.xpath("//li[text()='Engraved Jewelry']");


    public void navigateToRingsProduct(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(shopOptions)).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ringsProduct)));
        driver.findElement(ringsProduct).click();
    }

    public String getFirstProductAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProductAssertion)));
        return driver.findElement(firstProductAssertion).getText();
    }

    public void navigateToSecondProduct(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(shopOptions)).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(engravables)));
        driver.findElement(engravables).click();
    }

    public String getEngravablesAssertionMessage(){
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(engravablesAssertion)));
       return driver.findElement(engravablesAssertion).getText();
    }



}
