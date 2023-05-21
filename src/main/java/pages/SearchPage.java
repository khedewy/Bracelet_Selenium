package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SearchPage {
    private final WebDriver driver;
    Robot robot;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By searchBox = By.id("searchInput");
    private final By searchAssertion = By.xpath("//h1[@style='color: #000000']");
    private final By secondProductAssertion = By.xpath("//li[text()='Anklets & Ankle Bracelets']");

    public void searchForProduct(String product) throws AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchBox)));
        driver.findElement(searchBox).sendKeys(product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String searchAssertion(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchAssertion)));
        return driver.findElement(searchAssertion).getText();
    }

    public String secondProductAssertion(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(secondProductAssertion)));
        return driver.findElement(secondProductAssertion).getText();
    }


}
