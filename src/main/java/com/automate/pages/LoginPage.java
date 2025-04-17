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

    private WebDriver driver;
    private WebDriverWait wait;

    // Page Locators
    private final By pagePasswordBox = By.xpath("//input[@placeholder='xxxxxxxxxx']");
    private final By lockPageContinueButton = By.xpath("//button[normalize-space()='Continue']");
    private final By acceptCookieButton = By.xpath("//button[contains(text(),'قبول')]");
    private final By languageSelectionDropdown = By.xpath("//select[@id='languageSelectionTool']");
    private final By englishLanguage = By.xpath("//*[@id='languageSelectionTool']/option[1]");
    private final By switchToEmailButton = By.xpath("//button[normalize-space()='With email']");

    private final By phoneInputBox = By.xpath("//input[@class='form-control customPhoneInput']");
    private final By emailInputBox = By.xpath("//input[@placeholder='Please enter email address']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By incorrectPasswordWarning = By.xpath("//p[contains(text(),'Incorrect password')]");
    private final By userNotFoundWarning = By.xpath("//p[contains(text(),'User not found with provided credentials')]");
    private final By phoneDropdown = By.xpath("//div[contains(@class,'css-1dimb5e-singleValue')]//img");
    private final By phoneDropdownSelect = By.xpath("//img[@src='/assets/images/flags/in.png']");

    private final By userName  = By.xpath("//span[@class=' position-relative text-nowrap ']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Open Login Page
    public void openAkoLogin() {
        driver.get("https://akosayara.dev/Login");
        enterText(pagePasswordBox, PropertyReader.readItem("devsitepassword"));
        clickElement(lockPageContinueButton);
        clickElement(acceptCookieButton);
        switchLanguageToEnglish();
    }

    //switch language to english
    public void switchLanguageToEnglish(){
        clickDropdown(languageSelectionDropdown,englishLanguage);
    }

    // Login using email
    public void loginWithValidCredentialsEmail() {
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("validemail"));
        enterText(passwordInput, PropertyReader.readItem("validpassword"));
        clickElement(loginButton);
    }

    public void loginWithInValidCredentialsEmail() {
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("invalidemail"));
        enterText(passwordInput, PropertyReader.readItem("invalidpassword"));
        clickElement(loginButton);
    }

    public void loginWithValidEmailAndInvalidPassword() {
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("validemail"));
        enterText(passwordInput, PropertyReader.readItem("invalidpassword"));
        clickElement(loginButton);
    }

    public void loginWithValidCredentialsPhone() {
        selectDropdown(phoneDropdown, phoneDropdownSelect);
        enterText(phoneInputBox, PropertyReader.readItem("validphonenumber"));
        enterText(passwordInput, PropertyReader.readItem("validpassword"));
        clickElement(loginButton);
    }

    public void loginWithValidPhoneAndInvalidPassword() {
        selectDropdown(phoneDropdown, phoneDropdownSelect);
        enterText(phoneInputBox, PropertyReader.readItem("validphonenumber"));
        enterText(passwordInput, PropertyReader.readItem("invalidpassword"));
        clickElement(loginButton);
    }

    public void loginWithInValidPhoneAndInvalidPassword() {
        selectDropdown(phoneDropdown, phoneDropdownSelect);
        enterText(phoneInputBox, PropertyReader.readItem("invalidphonenumber"));
        enterText(passwordInput, PropertyReader.readItem("invalidpassword"));
        clickElement(loginButton);
    }

    // Navigate to HomePage after login
    public HomePage afterLogin() {
        return new HomePage(driver);
    }

    // Utility Methods for Code Reusability
    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private void selectDropdown(By locator1, By locator2) {
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        element1.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
        element2.click();
    }

    public String invalidPasswordText() {
        waitForElementToAppear(incorrectPasswordWarning);
        return driver.findElement(incorrectPasswordWarning).getText();
    }

    public String userNotFoundText() {
        waitForElementToAppear(userNotFoundWarning);
        return driver.findElement(userNotFoundWarning).getText();
    }

    private void clickDropdown(By locator1, By locator2) {
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        element1.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
        element2.click();
    }

    public String loggedInAccount(){
        waitForElementToAppear(userName);
        return driver.findElement(userName).getText();
    }
}
