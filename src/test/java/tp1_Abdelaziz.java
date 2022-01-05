import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1_Abdelaziz {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

        //Implicit wait 2 secondes ici
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    //Chercher la machine à raclette
    @Test
    public void test1(){
        WebElement barreRecherche= driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        //driver.findElement(By.name("field-keywords"));
       // driver.findElement(By.cssSelector(""));
       // driver.findElement(By.xpath("//*[@id='twotabsearchtextbox'"));
       // driver.findElement(By.xpath("//*[@name='field-keywords'"));

    }

    @Test
    public void test2(){
        WebElement barreRecherche= driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //IMPLICIT WAIT HERE
        WebElement firstPhoto = driver.findElement(By.cssSelector("[data-cel-widget='search_result_1']"));
        firstPhoto.click();

        }
}
