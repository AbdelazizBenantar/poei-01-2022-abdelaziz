package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;
    By iphoneMenu = By.cssSelector(".ac-gn-link.ac-gn-link-iphone");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void openIphonePage(){
        driver.findElement(iphoneMenu).click();

    }
}
