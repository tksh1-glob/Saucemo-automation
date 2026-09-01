package com.testacademy.base;

import com.testacademy.pages.CartPage;
import com.testacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class LoggedInBasePage extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    protected LoggedInBasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        click(menuButton);
        click(logoutLink);
        return new LoginPage(driver);
    }

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }

    public int getCartItemsCount() {
        if (!isDisplayed(cartBadge)) {
            return 0;
        }
        return Integer.parseInt(getText(cartBadge));
    }
}