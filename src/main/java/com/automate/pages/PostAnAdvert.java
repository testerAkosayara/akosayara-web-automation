package com.automate.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automate.base.BasePage;
import com.automate.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.*;
import java.util.NoSuchElementException;
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
    private final By selectmake = By.xpath("//div[@class='selectCustom __value-container css-hlgwow']//div[@class='selectCustom __input-container css-19bb58m']");
    private final By selectmodel = By.xpath("/html/body/div/div/section/div/div/form/div[1]/div/div[2]/div/div/div/div/div[1]/div[2]");
    private final By selecttrim = By.xpath("");
    private final By selectyear = By.xpath("//select[@name='makeYear']");
    private final By selectcarimport = By.xpath("//select[@name='regional']");
    private final By selectbodycondition = By.xpath("//select[@name='condition']");
    private final By selectexteriorcolour = By.xpath("//select[@name='colour']");
    private final By selectinteriorcolour = By.xpath("//select[@name='interiorColor']");
    private final By nextbutton = By.xpath("//button[normalize-space()='Next']");

    //specifications
    private final By selectpaint = By.xpath("//select[@name='paint']");
    private final By selectkilometers = By.xpath("//input[@name='kilometers']");
    private final By selectgearbox = By.xpath("//select[@name='transmission']");
    private final By selectfueltype = By.xpath("//select[@name='fuel']");
    private final By selectbodytype = By.xpath("//select[@name='body']");
    private final By selectdoors = By.xpath("//select[@name='doors']");
    private final By selectseats = By.xpath("//select[@name='seats']");

    //features
    private final By selectfeature1 = By.xpath("//input[@name='fabricSeats']");
    private final By selectfeature2 = By.xpath("//input[@name='leatherSeats']");
    private final By selectfeature3 = By.xpath("//input[@name='heatedSeats']");
    private final By selectfeature4 = By.xpath("//input[@name='acSeats']");
    private final By selectfeature5 = By.xpath("//input[@name='blindSpot']");
    private final By selectfeature6 = By.xpath("//input[@name='parkingSensors']");
    private final By selectfeature7 = By.xpath("//input[@name='smartParking']");
    private final By selectfeature8 = By.xpath("//input[@name='electricMirrors']");
    private final By selectfeature9 = By.xpath("//input[@name='bluetooth']");
    private final By selectfeature10 = By.xpath("//input[@name='touchscreen']");
    private final By selectbrandnew = By.xpath("//select[@name='brandNew']");

    //price section
    private final By selectplatetype = By.xpath("//select[@name='plateType']");
    private final By enterpriceiniqd = By.xpath("//input[@name='asking_price']");

    //images
    private final By uploadicon = By.xpath("//input[@name='file']");
    private final By saveandcontinuebutton = By.xpath("//button[@type='submit']");

    String image1Path = System.getProperty("user.dir") + "src/main/resources/Images/image1.jpg";
    String image2Path = System.getProperty("user.dir") + "src/main/resources/Images/image2.jpg";
    String image3Path = System.getProperty("user.dir") + "src/main/resources/Images/image3.jpg";
    String image4Path = System.getProperty("user.dir") + "src/main/resources/Images/image4.jpg";


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
        selectCustomDropdown(selectmake,PropertyReader.readItem("make"));
        selectCustomDropdown(selectmodel,PropertyReader.readItem("model"));
        selectDropdown(selectyear,PropertyReader.readItem("year"));
        selectDropdown(selectcarimport,PropertyReader.readItem("carimport"));
        selectDropdown(selectbodycondition,PropertyReader.readItem("bodycondition"));
        selectDropdown(selectexteriorcolour,PropertyReader.readItem("exteriorcolour"));
        selectDropdown(selectinteriorcolour,PropertyReader.readItem("interiorcolour"));
        clickElement(nextbutton);
    }

    public void fillSpecifications(){
        selectDropdown(selectpaint,PropertyReader.readItem("paint"));
        enterText(selectkilometers,PropertyReader.readItem("kilometers"));
        selectDropdown(selectgearbox,PropertyReader.readItem("gearbox"));
        selectDropdown(selectfueltype,PropertyReader.readItem("fueltype"));
        selectDropdown(selectbodytype,PropertyReader.readItem("bodytype"));
        selectDropdown(selectdoors,PropertyReader.readItem("numberofdoors"));
        selectDropdown(selectseats,PropertyReader.readItem("numberofseats"));
        clickElement(nextbutton);
    }

    public void fillFeatures(){
        clickElement(selectfeature1);
        clickElement(selectfeature2);
        clickElement(selectfeature3);
        clickElement(selectfeature4);
        clickElement(selectfeature5);
        clickElement(selectfeature6);
        clickElement(selectfeature7);
        clickElement(selectfeature8);
        clickElement(selectfeature9);
        clickElement(selectfeature10);
        selectDropdown(selectbrandnew,PropertyReader.readItem("brandnew"));
        clickElement(nextbutton);
    }

    public void fillPriceSection(){
        selectDropdown(selectplatetype,PropertyReader.readItem("platetype"));
        enterText(enterpriceiniqd,PropertyReader.readItem("price"));
        clickElement(saveandcontinuebutton);
    }

    public void fillImagesSection(){
        List<String> images = Arrays.asList(
                image1Path,
                image2Path,
                image3Path,
                image4Path
        );
        String joinedPaths = String.join("\n", images);
        uploadMultipleImages(uploadicon,joinedPaths);
        clickElement(saveandcontinuebutton);
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

    private void selectDropdown(By selectLocator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(selectLocator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    private void selectCustomDropdown(By dropdownLocator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int attempts = 0;
        boolean success = false;

        while (attempts < 3 && !success) {
            try {
                WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
                dropdown.click();

                By optionLocator = By.xpath("//div[contains(@class, 'selectCustom')]//div[text()='" + optionText + "']");
                WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", option);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

                success = true;
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            } catch (Exception e) {
                attempts++;
                System.out.println("Attempt " + attempts + " failed. Retrying...");
                if (attempts == 3) {
                    System.out.println("Failed to select the option after 3 attempts.");
                    throw e;
                }
            }
        }
    }


    public void uploadMultipleImages(By uploadInput, String imagePaths) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the file input's parent icon to be clickable
        WebElement uploadIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='st uploaddetaildiv']//i")));
        uploadIcon.click(); // Click the icon to trigger file input

        // Wait for the file input to be present and clickable
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadInput));
        wait.until(ExpectedConditions.elementToBeClickable(uploadInput));

        WebElement fileInputElement = driver.findElement(uploadInput);

        // Set the file paths using JavaScript if the element is not interactable in the normal way
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInputElement);  // Make sure it's visible

        fileInputElement.sendKeys(imagePaths); // Upload the files

        // Wait for the upload to complete and the "Save and Continue" button to be enabled
//        try {
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".upload-spinner")));
//        } catch (TimeoutException e) {
//            System.out.println("Upload spinner didn't disappear in time.");
//        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveandcontinuebutton));
        } catch (TimeoutException e) {
            throw new RuntimeException("Save and Continue button didn't become clickable.");
        }

        System.out.println("Images uploaded successfully, and 'Save and Continue' button is now enabled.");
    }


}
