package com.automate.base;

import com.automate.utils.DriverManager;
import com.automate.utils.PropertyReader;
import com.automate.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;
    private final PropertyReader pr = new PropertyReader();

    public TestBase() {
        Log.info("Initializing WebDriver Settings...");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = pr.readItem("browser").toLowerCase(); // Convert to lowercase for consistency

        try {
            if (browser.equals("chrome")) {
                Log.info("Launching Chrome Browser...");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized"); // Maximizing the browser
//                options.addArguments("--headless=new"); // Run in headless mode
//                options.addArguments("--disable-gpu"); // Disable GPU acceleration
//                options.addArguments("--window-size=1920,1080"); // Set a fixed window size

                driver = new ChromeDriver(options);
            } else if (browser.equals("firefox")) {
                Log.info("Launching Firefox Browser...");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                throw new Exception("Unsupported browser: " + browser);
            }

        } catch (Exception e) {
            Log.error("Browser Launch Failure: ", e);
            throw new RuntimeException("Failed to launch browser: " + browser, e);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            Log.info("Closing WebDriver...");
            driver.quit();
        } else {
            Log.warn("WebDriver was already null. Skipping quit.");
        }
    }

}
