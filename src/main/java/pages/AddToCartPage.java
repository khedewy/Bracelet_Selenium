package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstProduct = By.xpath("//div[text()='Wave Ring']");
    private final By firstProductAssertion = By.xpath("//h1[text()='Wave Ring']");
    private final By addToCartButton = By.xpath("//button[@class='product__add-to-cart button button--large button--full button--teal']");
    private final By addProductAssertion = By.xpath("//div[text()='جنيه527.33 EGP']");

    public void navigateToFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(firstProduct)));
        driver.findElement(firstProduct).click();
    }
    public String getFirstProductAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(firstProductAssertion).getText();
    }
    public void addTCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addToCartButton).click();
    }

    public String getAddProductToCartAssertion(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(addProductAssertion).getText();
    }
}
