package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CustomPage {
    private final WebDriver driver;
    JavascriptExecutor js;
    public CustomPage(WebDriver driver){
        this.driver = driver;
    }

    private final By customIcons = By.id("desktop-nav-custom");
    private final By customPageAssertion = By.xpath("//h1[@style='color: #000']");
    private final By EngravableProduct = By.xpath("//*[@id=\"product_grid_form_4401463525462\"]/a/div[2]");
    private final By writingBox = By.id("engravingText");
    private final By symbolIcon = By.xpath("//button[@title='Basketball']");
    private final By acceptTerms = By.id("acceptTerms");
    private final By addToCartButton = By.xpath("//button[@class='product__add-to-cart button button--large button--full button--teal']");
    private final By looksGreat = By.xpath("//button[text()='Looks great!']");
    private final By addToCartAssertion = By.xpath("//div[text()='جنيه790.99 EGP']");

    public void navigateToCustomPage(){
        driver.findElement(customIcons).click();
    }

    public String getCustomPageAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver.findElement(customPageAssertion).getText();
    }

    public void customAnProduct(String custom)  {
        js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(EngravableProduct).click();
        js.executeScript("scrollBy(0,250)");
        driver.findElement(writingBox).sendKeys(custom);
        js.executeScript("scrollBy(0,350)");
        driver.findElement(symbolIcon).click();
        js.executeScript("scrollBy(0,500)");
        driver.findElement(acceptTerms).click();
    }

    public void addCustomToCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(addToCartButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(looksGreat).click();

    }

    public String getAddToCartAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver.findElement(addToCartAssertion).getText();
    }
}
