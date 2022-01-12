package amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    Logger log = LogManager.getLogger(AmazonTest.class);
    int timeoutSearch = 10;

     By searchBarSelector = By.id("twotabsearchtextbox");
     By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");


    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String productName){
        //Trouver l'élément et intéragir avec
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);
        //Attendre que l'action soit finie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch));
        wait.until((ExpectedConditions.elementToBeClickable(searchResultSelector)));
    }
}
