import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UberEatsTest {
    WebDriver  driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

        //Ouvrerture de la page ubereats
        driver.get("https://www.ubereats.com/fr");
        driver.manage().window().maximize();
        //Fermeture des cookies en cliquant sur le bouton accepter
        WebElement buttonCookies = driver.findElement(By.cssSelector(".bc.gh.gi.gl.bj.bk.bl.bm.bn.bo.bt.bu.ba.bb"));
        buttonCookies.click();
    }


    @Test
    public void testOrderBurger() throws InterruptedException {

        //Arrange
        String restaurtAdress = "La Defense";
        String expectedCartItems = "1";

        By serachBarSelector = By.id("location-typeahead-home-input");
        By autocompleteSelector = By.cssSelector("#location-typeahead-home-menu > li");
        By searchCategorySelector = By.cssSelector("[alt='Burgers']");
        By searchRestaurantSelector = By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
        By searchDishSelector = By.cssSelector("[alt='Le Marcel Jackson']");
        By addToCartButtonSelector = By.cssSelector(".spacer._24 + button.b8");
        By cartSelector = By.cssSelector("button[aria-label='checkout'] > div");


        //Act
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement barreRecherche = driver.findElement(serachBarSelector);
        barreRecherche.sendKeys(restaurtAdress);

        wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteSelector));
        barreRecherche.sendKeys(Keys.ENTER);

        //Choisir la categorie Burgers dans la section "Explorer par categorie"
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(searchCategorySelector));
        WebElement burgerButton = driver.findElement(searchCategorySelector);
        burgerButton.click();

       //Dans la liste de restaurants, ouvrir le restaurant "King Marcel"
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchRestaurantSelector));
        WebElement restaurantName = driver.findElement(searchRestaurantSelector);
        restaurantName.click();

        //Dans la liste de plats, ajouter le premier plat au panier
        wait.until(ExpectedConditions.elementToBeClickable(searchDishSelector));
        WebElement dishName = driver.findElement(searchDishSelector);
        dishName.click();

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonSelector));
        WebElement addToCart = driver.findElement(addToCartButtonSelector);
        addToCart.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartButtonSelector));


       //Assert
        WebElement cart = driver.findElement(cartSelector);
        Assert.assertTrue(cart.getText().contains(expectedCartItems), "Error!!! ----> Your cart doesn't contain one item as requested");


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
