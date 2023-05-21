package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import java.awt.*;

public class SearchTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;

    @Test
    public void navigateToSearchPage(){
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage();
    }

    @Test(priority = 1)
    public void searchForProduct() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct("rings");
        Assert.assertEquals(searchPage.searchAssertion(),"RINGS");
    }

    @Test(priority = 2)
    public void navigateToSearchPageAgain(){
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage();
    }

    @Test(priority = 3)
    public void searchForAnotherProduct() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct("anklet");
        Assert.assertEquals(searchPage.secondProductAssertion(),"ANKLETS & ANKLE BRACELETS");
    }
}
