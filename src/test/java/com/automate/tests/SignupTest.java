package com.automate.tests;

import com.automate.base.TestBase;
import com.automate.pages.SignUp;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupTest extends TestBase{


    @Step
    @Description("Creating a private user account with Email")
    @Test(priority = 1)
    public void CreatePrivateAccountWithEmail() { // done
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withEmailPrivate();
        signup.enterBasicDetailsForPrivateWithEmail();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Creating a private user account with Phone")
    @Test(priority = 2)
    public void CreatePrivateAccountWithPhone() { // done
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withPhonePrivate();
        signup.enterBasicDetailsForPrivateWithPhone();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Creating a dealer account with email")
    @Test(priority = 3)
    public void CreateDealerAccountWithEmail() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withEmailDealer();
        signup.enterBasicDetailsForDealerWithEmail();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Creating a dealer account with Phone")
    @Test(priority = 4)
    public void CreateDealerAccountWithPhone() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withPhoneDealer();
        signup.enterBasicDetailsForDealerWithPhone();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Creating a brand account with Email")
    @Test(priority = 5)
    public void CreateBrandAccountWithEmail() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withEmailBrand();
        signup.enterBasicDetailsForBrandWithEmail();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Creating a brand account with Phone")
    @Test(priority = 6)
    public void CreateBrandAccountWithPhone() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withPhoneBrand();
        signup.enterBasicDetailsForBrandWithPhone();
        Assert.assertEquals(signup.getWelcomeText(), "Welcome to Ako Sayara");
    }

    @Step
    @Description("Checking warning for existing email")
    @Test(priority = 7)
    public void CheckWarningForExistingEmail() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withExistingEmail();
        Assert.assertEquals(signup.getExistingUserWarningText(), "User already exists with this email / phone number");

    }

    @Step
    @Description("Checking warning for existing Phone Number")
    @Test(priority = 8)
    public void CheckWarningForExistingPhoneNumber() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withExistingPhoneNumber();
        Assert.assertEquals(signup.getExistingUserWarningText(), "User already exists with this email / phone number");

    }

    @Step
    @Description("Checking warning for mismatched password using email")
    @Test(priority = 9)
    public void CheckWarningForMismatchedPasswordEmail() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withMismatchPasswordEmail();
        Assert.assertEquals(signup.getMismatchedPasswordWarningText(), "Your password does not match");

    }

    @Step
    @Description("Checking warning for mismatched password using email")
    @Test(priority = 10)
    public void CheckWarningForMismatchedPasswordPhoneNumber() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withMismatchPasswordPhoneNumber();
        Assert.assertEquals(signup.getMismatchedPasswordWarningText(), "Your password does not match");

    }

    @Step
    @Description("Test signup with empty fields")
    @Test(priority = 11)
    public void testSignupWithEmptyFieldsEmail() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withEmptyFieldsEmail();
        Assert.assertEquals(signup.getEmailRequiredWarningText(), "Email is a required");
        Assert.assertEquals(signup.getPasswordRequiredWarningText(), "Password is a required");
        Assert.assertEquals(signup.getConfirmPasswordRequiredWarningText(), "Please enter confirmed password");
    }

    @Step
    @Description("Test signup with empty fields")
    @Test(priority = 12)
    public void testSignupWithEmptyFieldsPhoneNumber() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withEmptyFieldsPhoneNumber();
        Assert.assertEquals(signup.getInvalidPhoneNumberWarningText(), "Phone number is not valid");
        Assert.assertEquals(signup.getPasswordRequiredWarningText(), "Password is a required");
        Assert.assertEquals(signup.getConfirmPasswordRequiredWarningText(), "Please enter confirmed password");

    }

    @Step
    @Description("Test for Invalid Email Format")
    @Test(priority = 13)
    public void testInvalidEmailFormat() {
        SignUp signup = new SignUp(driver);
        signup.openAkoSignUp();
        signup.switchLanguageToEnglish();
        signup.withInvalidStructureEmail();
        Assert.assertEquals(signup.getInvalidEmailWarningText(), "Please enter a valid email address");

    }




}