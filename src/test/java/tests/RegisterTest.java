package tests;

import data.ReadRegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;


public class RegisterTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());


    @Test
    public void NavigateToCreateAccount(){
        homePage = new HomePage(driver);
        homePage.navigateToCreateAccount();
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getCreateAccountAssertionMessage(),"CREATE AN ACCOUNT");
    }

    @Test(priority = 1)
    public void enterUserData() throws IOException, ParseException, InterruptedException {
        ReadRegisterData data = new ReadRegisterData();
        data.UserData();
        registerPage = new RegisterPage(driver);
        registerPage.enterUserInfo(data.firstName, data.lastName, data.email+currentTime+"@gmail.com", data.password);
    }

    @Test(priority = 2)
    public void RegisterAssertion() throws InterruptedException {
        registerPage = new RegisterPage(driver);
        registerPage.navigateToAccountInf();
        Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(),"HI, MAHMOUD!\n" +
                "NICE TO HAVE YOU BACK.");
    }

}
