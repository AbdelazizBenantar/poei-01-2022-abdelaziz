package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    By iphoneMenu = By.cssSelector(".ac-gn-link.ac-gn-link-iphone");
    By iphone13ProFigure = By.cssSelector(".chapternav-item-iphone-13-pro");
    int timeoutAppearIphonePage = 10;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openIphonePage(){
        driver.findElement(iphoneMenu).click();
        // attendre que l'action soit finie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutAppearIphonePage));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphone13ProFigure));

    }
}
