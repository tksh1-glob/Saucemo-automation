package com.testacademy.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Clase padre de todos los Page Objects del proyecto.
 * Guarda el driver y el wait, e inicializa los elementos anotados con
 * @FindBy en las clases hijas a través de PageFactory.
 *
 * Ninguna página debería interactuar con Selenium directamente (findElement,
 * click, sendKeys); todas pasan por los métodos de acá para que las esperas
 * queden centralizadas en un solo lugar.
 */
public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Esto es lo que "activa" las anotaciones @FindBy en la clase hija.
        PageFactory.initElements(driver, this);
    }

    // Espera a que el elemento sea clickeable (visible + habilitado) antes de hacer click.
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Limpia el campo antes de escribir, para evitar que se concatene con texto viejo.
    protected void type(WebElement element, String text) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    // Devuelve false en vez de lanzar excepción cuando el elemento no existe o no es visible,
    // para poder usarlo en validaciones tipo "¿está esto en pantalla?" sin try/catch en el test.
    protected boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
