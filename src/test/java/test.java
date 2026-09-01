import com.testacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {
    @Test
    public void checkLoginPageLoads() {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver).open();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
        driver.quit();
    }
}