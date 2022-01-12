package amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAddToCartPage {
    WebDriver driver;
    Logger log = LogManager.getLogger(AmazonTest.class);
    By cartButtonSelector = By.id("nav-cart");

    public ConfirmationAddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cartButtonSelector).click();
    }
}