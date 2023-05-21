package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShopPage;

public class ShopTest extends TestBase{
    ShopPage shop;

    @Test
    public void HoverOverRings(){
        shop = new ShopPage(driver);
        shop.navigateToRingsProduct();
        Assert.assertEquals(shop.getFirstProductAssertionMessage(),"RINGS");
    }

    @Test(priority = 1)
    public void HoverOverEngravable(){
        shop = new ShopPage(driver);
        shop.navigateToSecondProduct();
        Assert.assertEquals(shop.getEngravablesAssertionMessage(),"ENGRAVED JEWELRY");
    }
}
