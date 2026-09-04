package com.testacademy.base;

import com.testacademy.pages.CartPage;
import com.testacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Base para todas las páginas que solo existen una vez que el usuario inició sesión
 * (inventario, carrito, los pasos del checkout, etc).
 *
 * El menú lateral, el link de logout y el ícono del carrito son idénticos en todas
 * esas pantallas, así que se definen una sola vez acá en lugar de repetirlos
 * en cada Page Object.
 */
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

    // Abre el menú lateral y hace logout. Al terminar la sesión ya no queda
    // ningún dato válido de esta página, por eso se devuelve un LoginPage nuevo.
    public LoginPage logout() {
        click(menuButton);
        click(logoutLink);
        return new LoginPage(driver);
    }

    public CartPage goToCart() {
        click(cartIcon);
        return new CartPage(driver);
    }

    // El badge del carrito solo aparece en el DOM cuando hay al menos un producto,
    // por eso primero se chequea si está visible antes de intentar leer su texto.
    public int getCartItemsCount() {
        if (!isDisplayed(cartBadge)) {
            return 0;
        }
        return Integer.parseInt(getText(cartBadge));
    }
}
