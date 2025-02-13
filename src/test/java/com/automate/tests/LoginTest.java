package com.automate.tests;

import com.automate.base.TestBase;
import com.automate.pages.HomePage;
import com.automate.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Step
    @Description("Login to the Akosayara")
    @Test(enabled = true)
    public void loginAko() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAko( );
        loginPage.loginWithValidCredentialsEmail( );
    }

    @Step
    @Description("Login to the Akosayara and Verify Homepage")
    @Test
    public void loginAndVerifyDashboard() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAko();
        loginPage.loginWithValidCredentialsEmail( );
        HomePage dashboardPage = loginPage.afterLogin();
        Assert.assertEquals(dashboardPage.loggedInAccount( ), "My account");

    }
}
