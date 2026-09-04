package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object de la pantalla final de la compra
 * ("Thank you for your order!").
 */
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
