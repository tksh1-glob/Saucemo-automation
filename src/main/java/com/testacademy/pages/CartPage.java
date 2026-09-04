package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page Object del carrito de compras.
 */
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

    // Elimina todos los productos del carrito, uno a la vez, hasta que la lista
    // quede vacía. Como cartItems se re-consulta en cada acceso, el bucle
    // termina solo apenas se remueve el último producto.
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
