package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends LoggedInBasePage {

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getCompleteHeaderText() {
        return getText(completeHeader);
    }

    public boolean isPurchaseCompleted() {
        return isDisplayed(completeHeader);
    }
}