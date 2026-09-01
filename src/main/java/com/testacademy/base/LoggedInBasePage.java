package com.testacademy.base;

import org.openqa.selenium.WebDriver;

public abstract class LoggedInBasePage extends BasePage {
    protected LoggedInBasePage(WebDriver driver) {
        super(driver);
    }
}