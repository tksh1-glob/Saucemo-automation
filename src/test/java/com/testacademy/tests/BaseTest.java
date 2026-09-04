package com.testacademy.tests;

import com.testacademy.pages.InventoryPage;
import com.testacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public abstract class BaseTest {

    protected static final String VALID_USERNAME = "standard_user";
    protected static final String VALID_PASSWORD = "secret_sauce";

    protected WebDriver driver;
    protected InventoryPage inventoryPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_leak_detection", false
        ));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver).open();
        inventoryPage = loginPage.login(VALID_USERNAME, VALID_PASSWORD);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}