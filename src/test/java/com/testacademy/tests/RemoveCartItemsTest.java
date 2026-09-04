package com.testacademy.tests;

import com.testacademy.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Escenario 2: agregar 3 productos distintos al carrito, eliminarlos
 * todos y verificar que el carrito quede vacío.
 */
public class RemoveCartItemsTest extends BaseTest {

    private static final int PRODUCTS_TO_ADD = 3;

    @Test(description = "Agrega 3 productos y los elimina, dejando el carrito vacío")
    public void removeAllProductsFromCart_shouldLeaveCartEmpty() {
        inventoryPage.addMultipleProductsToCart(PRODUCTS_TO_ADD);
        // Se valida en el badge del catálogo antes de entrar al carrito,
        // para confirmar que los 3 productos realmente se agregaron.
        Assert.assertEquals(inventoryPage.getCartItemsCount(), PRODUCTS_TO_ADD);

        CartPage cartPage = inventoryPage.goToCart();
        Assert.assertFalse(cartPage.isCartEmpty());

        cartPage.removeAllProducts();

        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
