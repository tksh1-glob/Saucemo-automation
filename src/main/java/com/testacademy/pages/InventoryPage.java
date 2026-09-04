package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * Page Object del catálogo de productos (la pantalla que aparece justo
 * después de loguearse).
 */
public class InventoryPage extends LoggedInBasePage {

    // PageFactory re-busca esta lista en el DOM cada vez que se usa, así que
    // siempre refleja los productos que hay en pantalla en ese momento.
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Elige un producto al azar del catálogo y lo agrega al carrito.
    public InventoryPage addRandomProductToCart() {
        int randomIndex = new Random().nextInt(inventoryItems.size());
        return addProductToCartByIndex(randomIndex);
    }

    // Agrega los primeros "amount" productos del catálogo, uno por uno.
    public InventoryPage addMultipleProductsToCart(int amount) {
        for (int i = 0; i < amount && i < inventoryItems.size(); i++) {
            addProductToCartByIndex(i);
        }
        return this;
    }

    // Cada tarjeta de producto tiene su propio botón "Add to cart", por eso
    // se busca el botón dentro del elemento del producto en lugar de por id fijo.
    private InventoryPage addProductToCartByIndex(int index) {
        WebElement item = inventoryItems.get(index);
        WebElement addToCartButton = item.findElement(By.cssSelector("button"));
        click(addToCartButton);
        return this;
    }
}
