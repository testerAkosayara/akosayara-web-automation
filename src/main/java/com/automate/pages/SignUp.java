package com.automate.pages;

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


public class SignUp extends BasePage {


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
    private final By phoneInputBox = By.xpath("//input[@class='form-control customPhoneInput']");
    private final By passwordInputBox1 = By.xpath("//input[@name='password']");
    private final By passwordInputBox2 = By.xpath("//input[@name='confirmPassword']");
    private final By dealerSelectButton = By.xpath("//li[normalize-space()='Dealer']");
    private final By brandSelectButton = By.xpath("//li[normalize-space()='Brand']");
    private final By signupButton = By.xpath("//button[normalize-space()='Sign up']");
    private final By verifyLaterButton = By.xpath("//button[normalize-space()='Verify later']");

    //basic details
    //for private
    private final By privatefullNameInputField = By.xpath("//div[@id='Personal']//input[@placeholder='Please enter full name']");
    private final By privateemailInputField = By.xpath("//div[@id='Personal']//input[@placeholder='Please enter email address']");
    private final By privatephoneInputField = By.xpath("//div[@id='Personal']//input[2]");
    private final By privategenderDropdown = By.xpath("//div[@id='Personal']//select[@name='gender']");
    private final By privatemaleDropDownValue = By.xpath("//div[@id='Personal']//option[@value='Male']");
    private final By privatecityInputField = By.xpath("//div[@class='selectCustom __value-container selectCustom __value-container--has-value css-hlgwow']//div[@class='selectCustom __input-container css-19bb58m']");
    private final By privateaddressInputField = By.xpath("//div[@id='Personal']//textarea[@name='address']");
    private final By privatecontinueButton = By.xpath("//div[@id='Personal']//button[@type='submit'][normalize-space()='Continue']");

    //for dealer
    private final By dealerfullNameInputField = By.xpath("//div[@id='Dealer']//input[@placeholder='Please enter full name']");
    private final By dealerNameInputField = By.xpath("//input[@placeholder='Please enter dealership name']");
    private final By dealeremailInputField = By.xpath("//div[@id='Dealer']//input[@placeholder='Please enter email address']");
    private final By dealerphoneInputField = By.xpath("//div[@id='Dealer']//input[2]");
    private final By dealergenderDropdown = By.xpath("//div[@id='Dealer']//select[@name='gender']");
    private final By dealermaleDropDownValue = By.xpath("//div[@id='Dealer']//option[@value='Male']");
    private final By dealercityInputField = By.xpath("//div[@id='Dealer']//form//div[@class='form-group']//div//div[@class='selectCustom __input-container css-19bb58m']");
    private final By dealeraddressInputField = By.xpath("//div[@id='Dealer']//textarea[@name='address']");
    private final By dealercontinueButton = By.xpath("//div[@id='Dealer']//button[@type='submit'][normalize-space()='Continue']");

    //for Brand
    private final By brandNameInputField = By.xpath("//input[@placeholder='Please enter brand name']");
    private final By managerName = By.xpath("//div[@id='Brand']//input[@placeholder='Please enter full name']");
    private final By brandemailInputField = By.xpath("//div[@id='Brand']//input[@placeholder='Please enter email address']");
    private final By brandphoneInputField = By.xpath("//div[@id='Brand']//input[2]");
    private final By brandgenderDropdown = By.xpath("//div[@id='Brand']//select[@name='gender']");
    private final By brandmaleDropDownValue = By.xpath("//div[@id='Brand']//option[@value='Male']");
    private final By brandcityInputField = By.xpath("//div[@id='Brand']//form//div[@class='form-group']//div//div[@class='selectCustom __input-container css-19bb58m']");
    private final By brandaddressInputField = By.xpath("//div[@id='Brand']//textarea[@name='address']");
    private final By brandcontinueButton = By.xpath("//div[@id='Brand']//button[@type='submit'][normalize-space()='Continue']");



    private final By uploadIcon = By.xpath("//input[@name='file']");
    private final By uploadImageContinueButton = By.xpath("//div[@class='mt-5']/button");

    String imagePath = System.getProperty("user.dir") + "/src/main/resources/Images/image1.jpg";


    private final By welcomeText = By.xpath("//h1[normalize-space()='Welcome to Ako Sayara']");
    private final By existingUserWarning = By.xpath("//p[normalize-space()='User already exists with this email / phone number']");
    private final By mismatchedPasswordWarning = By.xpath("//p[normalize-space()='Your password does not match']");
    private final By emailRequiredWarning = By.xpath("//p[normalize-space()='Email is a required']");
    private final By invalidEmailWarning = By.xpath("//p[normalize-space()='Please enter a valid email address']");
    private final By invalidPhoneNumberWarning = By.xpath("//p[normalize-space()='Phone number is not valid']");
    private final By passwordRequiredWarning = By.xpath("//p[normalize-space()='Password is a required']");
    private final By confirmPasswordWarning = By.xpath("//p[normalize-space()='Please enter confirmed password']");

    String email = "test_" + UUID.randomUUID().toString().substring(0, 4) + System.currentTimeMillis() + "@gmail.com";



    public SignUp(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
    }

    // Open SignUp Page
    public void openAkoSignUp() {
        driver.get("https://akosayara.dev/Sign-up");
        enterText(pagePasswordBox, PropertyReader.readItem("devsitepassword"));
        clickElement(lockPageContinueButton);
        clickElement(acceptCookieButton);
    }


    //switch language to english
    public void switchLanguageToEnglish(){
        clickDropdown(languageSelectionDropdown,englishLanguage);
    }

    public void withEmailPrivate(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, email);
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withEmailDealer(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, email);
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(dealerSelectButton);
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withEmailBrand(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, email);
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(brandSelectButton);
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withPhonePrivate(){
        enterText(phoneInputBox, generateRandomPhoneNumber());
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withPhoneDealer(){
        enterText(phoneInputBox, generateRandomPhoneNumber());
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(dealerSelectButton);
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withPhoneBrand(){
        enterText(phoneInputBox, generateRandomPhoneNumber());
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(brandSelectButton);
        clickElement(signupButton);
        clickElement(verifyLaterButton);

    }

    public void withExistingEmail(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("validemail"));
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(signupButton);
    }

    public void withExistingPhoneNumber(){
        enterText(phoneInputBox, PropertyReader.readItem("validphonenumber"));
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("signuppassword"));
        clickElement(signupButton);

    }

    public void withMismatchPasswordEmail(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("validemail"));
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("invalidpassword"));
        clickElement(signupButton);
    }

    public void withMismatchPasswordPhoneNumber(){
        enterText(phoneInputBox, PropertyReader.readItem("validphonenumber"));
        enterText(passwordInputBox1, PropertyReader.readItem("signuppassword"));
        enterText(passwordInputBox2, PropertyReader.readItem("invalidpassword"));
        clickElement(signupButton);
    }

    public void withEmptyFieldsEmail(){
        clickElement(switchToEmailButton);
        clickElement(signupButton);
    }
    public void withEmptyFieldsPhoneNumber(){
        clickElement(signupButton);
    }

    public void withInvalidStructureEmail(){
        clickElement(switchToEmailButton);
        enterText(emailInputBox, PropertyReader.readItem("invalidstructureemail"));
        clickElement(signupButton);
    }



    public void enterBasicDetailsForPrivateWithEmail(){
        enterText(privatefullNameInputField, PropertyReader.readItem("fullname"));
        enterText(privatephoneInputField, generateRandomPhoneNumber());
        clickDropdown(privategenderDropdown, privatemaleDropDownValue);
        selectCustomDropdown(privatecityInputField,PropertyReader.readItem("city"));
        enterText(privateaddressInputField,PropertyReader.readItem("address"));
        clickElement(privatecontinueButton);
    }
    public void enterBasicDetailsForPrivateWithPhone(){
        enterText(privatefullNameInputField, PropertyReader.readItem("fullname"));
        enterText(privateemailInputField, email);
        clickDropdown(privategenderDropdown, privatemaleDropDownValue);
        selectCustomDropdown(privatecityInputField,PropertyReader.readItem("city"));
        enterText(privateaddressInputField,PropertyReader.readItem("address"));
        clickElement(privatecontinueButton);
    }

    public void enterBasicDetailsForDealerWithEmail(){
        enterText(dealerfullNameInputField, PropertyReader.readItem("fullname"));
        enterText(dealerphoneInputField, generateRandomPhoneNumber());
        enterText(dealerNameInputField,PropertyReader.readItem("dealername"));
        clickDropdown(dealergenderDropdown, dealermaleDropDownValue);
        selectCustomDropdown(dealercityInputField,PropertyReader.readItem("city"));
        enterText(dealeraddressInputField,PropertyReader.readItem("address"));
        clickElement(dealercontinueButton);
        uploadImage(uploadIcon,imagePath);
        clickElement(uploadImageContinueButton);
    }

    public void enterBasicDetailsForDealerWithPhone(){
        enterText(dealerfullNameInputField, PropertyReader.readItem("fullname"));
        enterText(dealeremailInputField, email);
        enterText(dealerNameInputField,PropertyReader.readItem("dealername"));
        clickDropdown(dealergenderDropdown, dealermaleDropDownValue);
        selectCustomDropdown(dealercityInputField,PropertyReader.readItem("city"));
        enterText(dealeraddressInputField,PropertyReader.readItem("address"));
        clickElement(dealercontinueButton);
        uploadImage(uploadIcon,imagePath);
        clickElement(uploadImageContinueButton);
    }

    public void enterBasicDetailsForBrandWithEmail(){
        enterText(brandNameInputField,PropertyReader.readItem("brandname"));
        enterText(managerName, PropertyReader.readItem("fullname"));
        enterText(brandphoneInputField, generateRandomPhoneNumber());
        clickDropdown(brandgenderDropdown, brandmaleDropDownValue);
        selectCustomDropdown(brandcityInputField,PropertyReader.readItem("city"));
        enterText(brandaddressInputField,PropertyReader.readItem("address"));
        clickElement(brandcontinueButton);
        uploadImage(uploadIcon,imagePath);
        clickElement(uploadImageContinueButton);
    }

    public void enterBasicDetailsForBrandWithPhone(){
        enterText(brandNameInputField,PropertyReader.readItem("brandname"));
        enterText(managerName, PropertyReader.readItem("fullname"));
        enterText(brandemailInputField, email);
        clickDropdown(brandgenderDropdown, brandmaleDropDownValue);
        selectCustomDropdown(brandcityInputField,PropertyReader.readItem("city"));
        enterText(brandaddressInputField,PropertyReader.readItem("address"));
        clickElement(brandcontinueButton);
        uploadImage(uploadIcon,imagePath);
        clickElement(uploadImageContinueButton);
    }


    private void uploadImage(By locator, String imagePath) {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element.sendKeys(imagePath);

            // Adding a wait for upload completion
            wait.until(driver -> {
                WebElement inputElement = driver.findElement(locator);
                return inputElement.getAttribute("value") != null && !inputElement.getAttribute("value").isEmpty();
            });

        } catch (Exception e) {
            System.err.println("Error uploading image: " + e.getMessage());
        }
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

    public String getWelcomeText(){
        waitForElementToAppear(welcomeText);
        return driver.findElement(welcomeText).getText();
    }

    public String getExistingUserWarningText(){
        waitForElementToAppear(existingUserWarning);
        return driver.findElement(existingUserWarning).getText();
    }

    public String getMismatchedPasswordWarningText(){
        waitForElementToAppear(mismatchedPasswordWarning);
        return driver.findElement(mismatchedPasswordWarning).getText();
    }

    public String getEmailRequiredWarningText(){
        waitForElementToAppear(emailRequiredWarning);
        return driver.findElement(emailRequiredWarning).getText();
    }

    public String getPasswordRequiredWarningText(){
        waitForElementToAppear(passwordRequiredWarning);
        return driver.findElement(passwordRequiredWarning).getText();
    }

    public String getConfirmPasswordRequiredWarningText(){
        waitForElementToAppear(confirmPasswordWarning);
        return driver.findElement(confirmPasswordWarning).getText();
    }

    public String getInvalidPhoneNumberWarningText(){
        waitForElementToAppear(invalidPhoneNumberWarning);
        return driver.findElement(invalidPhoneNumberWarning).getText();
    }

    public String getInvalidEmailWarningText(){
        waitForElementToAppear(invalidEmailWarning);
        return driver.findElement(invalidEmailWarning).getText();
    }

    public String generateRandomPhoneNumber() {
        Random random = new Random();
        long number = 9000000000L + (long) (random.nextFloat() * 1000000000L); // Ensures 10-digit number
        return String.valueOf(number);
    }

}