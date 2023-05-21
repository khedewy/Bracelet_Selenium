package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomPage;

public class CustomTest extends TestBase{
    CustomPage customPage;

    @Test
    public void navigateToCustomPage(){
        customPage = new CustomPage(driver);
        customPage.navigateToCustomPage();
        Assert.assertEquals(customPage.getCustomPageAssertionMessage(),"CUSTOM");
    }

    @Test(priority = 1)
    public void customAnProduct() {
        customPage = new CustomPage(driver);
        customPage.customAnProduct("Mahmoud");
    }

    @Test(priority = 2)
    public void addCustomProductToCart(){
        customPage = new CustomPage(driver);
        customPage.addCustomToCart();
        Assert.assertEquals(customPage.getAddToCartAssertionMessage(),"جنيه790.99 EGP");
    }
}
