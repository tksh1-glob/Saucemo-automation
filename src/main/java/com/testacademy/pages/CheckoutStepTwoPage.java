package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object del segundo paso del checkout: el resumen de la orden
 * con el botón "Finish" para confirmar la compra.
 */
public class CheckoutStepTwoPage extends LoggedInBasePage {

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    // Confirma la compra y devuelve la pantalla de "Thank you for your order!".
    public CheckoutCompletePage finishPurchase() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}
