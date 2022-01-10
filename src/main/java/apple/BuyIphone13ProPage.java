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
    By iphoneStorageCapacity = By.cssSelector("[data-autom= 'dimensionCapacity256gb']+label");
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

    public void selectIphone13ProMax(){
        driver.findElement(iphoneModelName).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneModel));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneModelName));
        }

    public void selectBlueAlpin(){
        driver.findElement(iphoneColor).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneColor));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColor));
    }

    public void select256Go(){
        driver.findElement(iphoneStorageCapacity).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneStorageCapacity));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneStorageCapacity));
    }

    public void noAppleTradeIn(){
        driver.findElement(iphoneToTrade).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectNoTrade));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneToTrade));
    }

    public void addToCart(){
        driver.findElement(addIphoneToCart).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutAddIphoneToCart));
        wait.until(ExpectedConditions.visibilityOfElementLocated(consultCart));
        //wait.until(ExpectedConditions.elementToBeClickable(addIphoneToCart));
    }

}
