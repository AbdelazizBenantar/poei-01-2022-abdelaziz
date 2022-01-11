package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphone13ProPage {
    WebDriver driver;
    By iphoneModelName = By.cssSelector("[data-autom='dimensionScreensize6_7inch']+label");
    By iphoneColor = By.cssSelector("[data-autom= 'dimensionColorsierrablue']+label");
    By iphoneStorageCapacity = By.cssSelector("[data-autom='dimensionCapacity256gb']+label");
    By iphoneToTrade = By.cssSelector("[data-autom='choose-noTradeIn']+label");
    By addIphoneToCart = By.cssSelector("[data-autom='add-to-cart']");
    By consultCart = By.cssSelector("[data-autom='proceed']");


    int timeoutSelectIphoneModel =10;
    int timeoutSelectIphoneColor =10;
    int timeoutSelectIphoneStorageCapacity = 10;
    int timeoutSelectNoTrade = 10;
    int timeoutAddIphoneToCart = 10;


    public BuyIphone13ProPage(WebDriver driver){
        this.driver = driver;
    }

    public BuyIphone13ProPage selectIphone13ProMax(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneModel));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneModelName)).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
        }

    public BuyIphone13ProPage selectBlueAlpin(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneColor));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColor)).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BuyIphone13ProPage select256Go(){

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneStorageCapacity));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneStorageCapacity)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public BuyIphone13ProPage noAppleTradeIn(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectNoTrade));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneToTrade)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public ConfirmationAddToCartPage addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutAddIphoneToCart));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addIphoneToCart)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        return confirmationAddToCartPage;
    }

}
