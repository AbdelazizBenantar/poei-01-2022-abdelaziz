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

    public void openCartPage(){
        driver.findElement(consultCart).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutConfirmAddToCart));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmation));
    }
}
