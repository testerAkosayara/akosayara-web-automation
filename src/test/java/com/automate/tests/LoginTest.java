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
    @Description("Login to the Akosayara with valid email and password")
    @Test
    public void WithValidEmailAndPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithValidCredentialsEmail();
        Assert.assertEquals(loginPage.loggedInAccount(), "My account");
    }

    @Step
    @Description("checking login for invalid email")
    @Test
    public void WithInValidEmailAndInvalidPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithInValidCredentialsEmail();
        Assert.assertEquals(loginPage.userNotFoundText(), "User not found with provided credentials");
    }

    @Step
    @Description("Login to the Akosayara with valid email and invalid password")
    @Test
    public void WithValidEmailAndInvalidPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithValidEmailAndInvalidPassword();
        Assert.assertEquals(loginPage.invalidPasswordText(), "Incorrect password");
    }

    @Step
    @Description("Login to the Akosayara with valid phone and password and Verify Homepage")
    @Test
    public void withValidPhoneAndPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithValidCredentialsPhone();
        Assert.assertEquals(loginPage.loggedInAccount(), "My account");
    }

    @Step
    @Description("Login to the Akosayara and Verify Homepage")
    @Test
    public void LoginWithValidPhoneAndInvalidPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithValidPhoneAndInvalidPassword();
        Assert.assertEquals(loginPage.invalidPasswordText(), "Incorrect password");
    }

    @Step
    @Description("Login to the Akosayara and Verify Homepage")
    @Test
    public void LoginWithInvalidPhoneAndInvalidPassword() { // done
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openAkoLogin();
        loginPage.loginWithInValidPhoneAndInvalidPassword();
        Assert.assertEquals(loginPage.userNotFoundText(), "User not found with provided credentials");
    }
}
