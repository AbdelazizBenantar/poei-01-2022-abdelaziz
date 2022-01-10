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

    int timeoutSelectIphoneModel =3;
    int timeoutSelectIphoneColor =3;
    int timeoutSelectIphoneStorageCapacity = 3;


    public BuyIphone13ProPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectIphone13ProMax(){
        driver.findElement(iphoneModelName).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneModel));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneModelName));
        }

    public void selectBlueAlpin(){
        driver.findElement(iphoneColor).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneColor));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColor));
    }

    public void select256Go(){
        driver.findElement(iphoneStorageCapacity).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSelectIphoneStorageCapacity));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneStorageCapacity));
    }

}
