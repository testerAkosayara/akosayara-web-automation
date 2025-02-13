package com.automate.pages;

import com.automate.base.BasePage;
import com.automate.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Page Locators
    By phoneInputBox = By.xpath("//input[@class='form-control customPhoneInput']");
    By emailInputBox = By.xpath("//input[@placeholder='الرجاء إدخال عنوان البريد الإلكتروني']");
    By passwordInput = By.xpath("//input[@placeholder='الرجاء إدخال كلمة المرور']");
    By signInButton = By.xpath("//button[contains(text(),'تسجيل دخول')]");
    By switchToEmailButton = By.xpath("//button[contains(text(),'بالبريد الإلكتروني')]");
    By acceptcookiebutton = By.xpath("//button[contains(text(),'قبول')]");

    // Page Actions
    public void openAko() {
        driver.get("https://akosayara.com/Login");
        WebElement acceptcookies = wait.until(ExpectedConditions.elementToBeClickable(acceptcookiebutton));
        acceptcookies.click();
    }

    public void loginWithValidCredentialsEmail() {
        // Wait for and click the 'Switch to Email' button
        WebElement switchToEmail = wait.until(ExpectedConditions.elementToBeClickable(switchToEmailButton));
        switchToEmail.click();

        // Wait for and enter email
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(emailInputBox));
        emailField.sendKeys(PropertyReader.readItem("validemail"));

        // Wait for and enter password
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
        passwordField.sendKeys(PropertyReader.readItem("validpasswordforemail"));

        // Wait for and click the Sign In button
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signIn.click();
    }

    public HomePage afterLogin() {
        return new HomePage(driver);
    }
}

