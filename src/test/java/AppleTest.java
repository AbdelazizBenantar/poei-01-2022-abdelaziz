import apple.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppleTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();
    }

   /* @AfterMethod
    public void teardown() {
        driver.quit();
    }*/

    @Test
    public void iphone13ProMax256GoBleuAlpinAddToCartPriceTest() {
        // Arrange

        //Act
        MainPage mainPage = new MainPage(driver);
        mainPage.openIphonePage();


        //Assert


    }
}
