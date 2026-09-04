package com.testacademy.tests;

import com.testacademy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(description = "Cierra sesión y valida el redireccionamiento al login")
    public void logout_shouldRedirectToLoginPage() {
        LoginPage loginPage = inventoryPage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}