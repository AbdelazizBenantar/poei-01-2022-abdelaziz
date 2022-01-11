package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iphone13ProPage {
    WebDriver driver;
    By buyIphone13Pro = By.className("ac-ln-button");
    By buyOneIphone13proText = By.className("fwl");

    int timeoutAppearBuyIphone13ProPage = 10;

    public Iphone13ProPage(WebDriver driver) {
        this.driver = driver;
    }

    public BuyIphone13ProPage buy(){
        driver.findElement(buyIphone13Pro).click();
        // attendre que l'action soit finie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutAppearBuyIphone13ProPage));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyOneIphone13proText));

        BuyIphone13ProPage buyIphone13ProPage = new BuyIphone13ProPage(driver);
        return buyIphone13ProPage;
    }

    }
