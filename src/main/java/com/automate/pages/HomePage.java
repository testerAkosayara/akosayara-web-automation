package com.automate.pages;

import com.automate.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver );
        this.driver = driver;
    }

    By userName  = By.xpath("//span[@class=' position-relative text-nowrap ']");

    // Page Action
    public String loggedInAccount(){
        waitForElementToAppear(userName);
        return driver.findElement(userName).getText();
    }
}
