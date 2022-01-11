import apple.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppleTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void iphone13ProMax256GoBleuAlpinAddToCartPriceTest() {
        // Arrange

        String expectedProductName = "iPhone 13 Pro Max 256 Go Bleu Alpin";
        String expectedCartTotal = "Le montant total de votre Panier est de 1 379,00";
        String expectedProductPrice = "1 379,00";
        String expectedSubTotal = "1 379,00";
        String expectedTotal = "1 379,00";

        //Act
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = mainPage.openIphonePage()
                .openIphone13ProPage()
                .buy()
                .selectIphone13ProMax()
                .selectBlueAlpin()
                .select256Go()
                .noAppleTradeIn()
                .addToCart()
                .openCartPage();


     //Assert
        Assert.assertTrue(cartPage.getProductName(0).contains(expectedProductName));
        Assert.assertTrue(cartPage.getCartTotal(0).contains(expectedCartTotal));
        Assert.assertTrue(cartPage.getProductPrice(0).contains(expectedProductPrice));
        Assert.assertTrue(cartPage.getSubTotal(0).contains(expectedSubTotal));
        Assert.assertTrue(cartPage.getTotal(0).contains(expectedTotal));




    }
}
