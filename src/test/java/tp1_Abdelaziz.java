import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class tp1_Abdelaziz {
    //Chercher la machine à raclette
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
        WebElement barreRecherche= driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine à raclette");
        barreRecherche.sendKeys(Keys.ENTER);


        //driver.findElement(By.name("field-keywords"));
       // driver.findElement(By.cssSelector(""));
       // driver.findElement(By.xpath("//*[@id='twotabsearchtextbox'"));
       // driver.findElement(By.xpath("//*[@name='field-keywords'"));
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        driver.quit();

    }

    @Test
    public void test2(){

    }
}
