package com.automate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automate.base.BasePage;
import com.automate.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.Random;
import java.util.UUID;

public class PostAnAdvert extends BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //page locators
    private final By pagePasswordBox = By.xpath("//input[@placeholder='xxxxxxxxxx']");
    private final By lockPageContinueButton = By.xpath("//button[normalize-space()='Continue']");
    private final By acceptCookieButton = By.xpath("//button[contains(text(),'قبول')]");
    private final By languageSelectionDropdown = By.xpath("//select[@id='languageSelectionTool']");
    private final By englishLanguage = By.xpath("//*[@id='languageSelectionTool']/option[1]");
    private final By switchToEmailButton = By.xpath("//button[normalize-space()='With email']");
    private final By emailInputBox = By.xpath("//input[@placeholder='Please enter email address']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");

    private final By sellyourcarbutton = By.xpath("//a[@href='/Sell-your-car/Hero']");
    private final By startanadvertbutton = By.xpath("//a[normalize-space()='Start an advert']");
    private final By proceedtoadvertbutton = By.xpath("//a[normalize-space()='Proceed without VIN number']");

    //basic details
    private final By selectmake = By.xpath("");
    private final By selectmodel = By.xpath("");
    private final By selecttrim = By.xpath("");
    private final By selectyear = By.xpath("");
    private final By selectcarimport = By.xpath("");
    private final By selectbodycondition = By.xpath("");
    private final By selectexteriorcolour = By.xpath("");
    private final By selectinteriorcolour = By.xpath("");





    public PostAnAdvert(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Open SignUp Page
    public void openAko() {
        driver.get("https://akosayara.dev/Login");
        enterText(pagePasswordBox, PropertyReader.readItem("devsitepassword"));
        clickElement(lockPageContinueButton);
        clickElement(acceptCookieButton);
        switchLanguageToEnglish();
        loginWithValidCredentialsEmail();
    }


    //switch language to english
    public void switchLanguageToEnglish(){
        clickDropdown(languageSelectionDropdown,englishLanguage);
    }

    // logging in with valid credentials
    public void loginWithValidCredentialsEmail() {
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("validemail"));
        enterText(passwordInput, PropertyReader.readItem("validpassword"));
        clickElement(loginButton);
    }

    //navigating to posting sell advert
    public void startSellAdvert(){
        clickElement(sellyourcarbutton);
        clickElement(startanadvertbutton);
        clickElement(proceedtoadvertbutton);
    }

    public void fillBasicDetails(){

    }



    public void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private void clickDropdown(By locator1, By locator2) {
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        element1.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
        element2.click();
    }

    private void selectCustomDropdown(By dropdownLocator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();

        By optionLocator = By.xpath("//div[contains(@class, 'selectCustom')]//div[text()='" + optionText + "']");
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }
}
