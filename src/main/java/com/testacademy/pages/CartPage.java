package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends LoggedInBasePage {

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public CartPage removeAllProducts() {
        while (!cartItems.isEmpty()) {
            WebElement removeButton = cartItems.get(0).findElement(By.cssSelector("button.cart_button"));
            click(removeButton);
        }
        return this;
    }

    public CheckoutStepOnePage goToCheckout() {
        click(checkoutButton);
        return new CheckoutStepOnePage(driver);
    }
}