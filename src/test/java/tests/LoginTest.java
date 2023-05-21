package tests;

import data.ReadRegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage log;
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

    @Test(priority = 3)
    public void logOut(){
        homePage = new HomePage(driver);
        homePage.logOut();
    }

    @Test(priority = 4)
    public void navigateToLoginAndLogin() throws IOException, ParseException {
        ReadRegisterData data = new ReadRegisterData();
        data.UserData();
        homePage = new HomePage(driver);
        log = new LoginPage(driver);
        homePage.navigateToLoginPage();
        Assert.assertEquals(log.getLoginPageAssertionMessage(),"WELCOME BACK!");
        log.enterLoginInformation(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(log.getSuccessfulLoginAssertionMessage(),"HI, MAHMOUD!\n" +
                "NICE TO HAVE YOU BACK.");

    }
}
