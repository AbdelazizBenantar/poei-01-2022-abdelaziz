package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IphonePage {
    WebDriver driver;
    By iphone13ProFigure = By.cssSelector(".chapternav-item-iphone-13-pro");
    By buyIphone13Pro = By.className("ac-ln-button");
    int timeoutAppearIphone13ProPage = 10;
        public IphonePage(WebDriver driver){
            this.driver = driver;
        }

    public Iphone13ProPage openIphone13ProPage(){
        driver.findElement(iphone13ProFigure).click();
        // attendre que l'action soit finie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutAppearIphone13ProPage));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyIphone13Pro));

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        return iphone13ProPage;
    }
}
