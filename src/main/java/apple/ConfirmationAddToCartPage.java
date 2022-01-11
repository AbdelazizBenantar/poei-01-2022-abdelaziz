package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAddToCartPage {
    WebDriver driver;
    By consultCart = By.cssSelector("[data-autom='proceed']");
    By orderConfirmation = By.cssSelector("[data-autom='checkout']");
    int timeoutConfirmAddToCart =10;

    public ConfirmationAddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    public CartPage openCartPage(){
        driver.findElement(consultCart).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutConfirmAddToCart));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));

        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

}
