import amazon.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AmazonTest {

    WebDriver driver;
    Logger log = LogManager.getLogger(AmazonTest.class);



    @BeforeMethod
    public void setup() {
       // driver = new ChromeDriver();
        /*FATAL > ERROR > WARNING > INFO > DEBUG > TRACE
        log.fatal("Fatal");
        log.error("Error");
        log.warn("Warning");
        log.info("Abdelaziz was here");
        log.debug("Debug");
        log.trace("Trace");
        */
        log.debug("Chrome has started");

        driver.get("https://www.amazon.fr");
        log.info("AmazonHP is opened");
        driver.manage().window().maximize();
        log.trace("Th windows is maximized");
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);
    

        // fermer cookies
        driver.findElement(By.id("sp-cc-accept")).click();
        log.info("closed cookies windows");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        log.debug("Chrome was closed");
    }

    @Test
    public void hoverTest() {
        By buttonSelector =By.id("nav-link-accountList");
        WebElement button = driver.findElement(buttonSelector);
        log.debug("The button was found");
        Actions hover = new Actions(driver);

        hover.moveToElement(button);
        hover.perform();
        log.info("Mousse hover button");

        By myAccountSelector = By.cssSelector(" #nav-al-your-account .nav-title + a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement myAccountButton = wait.until(ExpectedConditions.elementToBeClickable(myAccountSelector));
        myAccountButton.click();
        log.info("my account page is opened");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void hpChromebookAddToCartPriceTest() {
        // Arrange
        String productName = "HP Chromebook x360 14a-ca0000sf";
        String expectedPrice = "369,00 €";

        // Act
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(productName);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openResult(0);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.noCoverage();

        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCart();

        CartPage cartPage = new CartPage(driver);
        String productPrice = cartPage.getProductPrice(0);
        String activeCartSubtotal = cartPage.getActiveCartSubtotal();
        String buyboxCartSubtotal = cartPage.getBuyboxCartSubtotal();

        // Assert
        Assert.assertTrue(productPrice.contains("369,00"));
        Assert.assertTrue(activeCartSubtotal.contains("369,00"));
        Assert.assertTrue(buyboxCartSubtotal.contains("369,00"));
        //Assert.assertEquals(productPrice, expectedPrice);
        //Assert.assertEquals(activeCartSubtotal, expectedPrice);
        // Assert.assertEquals(buyboxCartSubtotal, expectedPrice);
    }
}