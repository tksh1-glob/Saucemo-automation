package com.testacademy.pages;

import com.testacademy.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object de la pantalla de login (https://www.saucedemo.com/).
 * Es la única página que no hereda de LoggedInBasePage, porque todavía
 * no hay sesión iniciada: no tiene menú, ni carrito, ni logout.
 */
public class LoginPage extends BasePage {

    // Hace login con las credenciales dadas y devuelve el catálogo de productos,
    // que es la pantalla a la que SauceDemo redirige tras un login correcto.
    public InventoryPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new InventoryPage(driver);
    }

    private static final String URL = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Navega directamente a la URL de la app. Separado de login() para poder
    // usarlo también en el test de logout, donde no hace falta loguearse de nuevo.
    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginButton);
    }
}
