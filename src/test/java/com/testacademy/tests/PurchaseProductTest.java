package com.testacademy.tests;

import com.testacademy.pages.CheckoutCompletePage;
import com.testacademy.pages.CheckoutStepTwoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Escenario 1: comprar un producto elegido al azar y llegar hasta la
 * pantalla de confirmación de la orden.
 */
public class PurchaseProductTest extends BaseTest {

    @Test(description = "Completa el flujo de compra de un producto aleatorio")
    public void purchaseRandomProduct_shouldReachThankYouPage() {
        inventoryPage.addRandomProductToCart();

        // El login ya lo hizo el @BeforeMethod de BaseTest; acá solo se
        // encadena el resto del buyflow: carrito -> checkout -> datos -> finalizar.
        CheckoutStepTwoPage checkoutStepTwo = inventoryPage
                .goToCart()
                .goToCheckout()
                .fillPersonalInformation("John", "Doe", "12345");

        CheckoutCompletePage checkoutCompletePage = checkoutStepTwo.finishPurchase();

        Assert.assertTrue(checkoutCompletePage.isPurchaseCompleted());
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!");
    }
}
