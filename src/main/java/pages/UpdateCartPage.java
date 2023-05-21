package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UpdateCartPage {
    private final WebDriver driver;
    public UpdateCartPage(WebDriver driver){
        this.driver = driver;
    }
    private final By plusButton = By.xpath("/html/body/footer/mini-cart/section/div[2]/div/div[2]/div[1]/line-item/div/div[2]/div[2]/quantity-selector/div/button[2]");
    private final By onePlusAssertion = By.xpath("//div[ text()='جنيه1,054.66 EGP' ]");
    private final By towPlusAssertion = By.xpath("//div[ text()='جنيه1,318.98 EGP' ]");

    private final By removeItemsButton = By.xpath("//button[@class='cart__item-remove']");
    private final By removeAssertion = By.xpath("//span[text()='Your cart looks a little empty!']");

    public void clickPlusButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(plusButton).click();
    }

    public String firstPlusAssertion(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        return driver.findElement(onePlusAssertion).getText();
    }

    public String towPlusAssertion(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        return driver.findElement(towPlusAssertion).getText();
    }

    public void removeItem(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.findElement(removeItemsButton).click();
    }

    public String removeItemAssertion(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        return driver.findElement(removeAssertion).getText();
    }
}
