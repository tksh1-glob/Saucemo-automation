package com.testacademy.pages;

import com.testacademy.base.LoggedInBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class InventoryPage extends LoggedInBasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage addRandomProductToCart() {
        int randomIndex = new Random().nextInt(inventoryItems.size());
        return addProductToCartByIndex(randomIndex);
    }

    public InventoryPage addMultipleProductsToCart(int amount) {
        for (int i = 0; i < amount && i < inventoryItems.size(); i++) {
            addProductToCartByIndex(i);
        }
        return this;
    }

    private InventoryPage addProductToCartByIndex(int index) {
        WebElement item = inventoryItems.get(index);
        WebElement addToCartButton = item.findElement(By.cssSelector("button"));
        click(addToCartButton);
        return this;
    }
}