package apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By productNameSelector = By.cssSelector("[data-autom='bag-item-name']");
    By cartTotalSelector = By.cssSelector("[data-autom='bag-header']");
    //By productPriceSelector = By.className(".rs-iteminfo-price");
    By productPriceSelector = By.cssSelector("div[class='rs-iteminfo-price'] p");
    //By subTotalSelector = By.cssSelector("[data-autom='bagrs-summary-subtotalvalue']");
    By subTotalSelector = By.cssSelector("div[data-autom='bagrs-summary-subtotalvalue");
    By totalSelector = By.cssSelector("[data-autom='bagtotalvalue']");


    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(int index) {
        return driver.findElements(productNameSelector).get(index).getText();
    }

    public String getCartTotal(int index) {
        return driver.findElements(cartTotalSelector).get(index).getText();
    }

    public String getProductPrice(int index) {
        return driver.findElements(productPriceSelector).get(index).getText();
    }

    public String getSubTotal(int index) {
        return driver.findElements(subTotalSelector).get(index).getText();
    }

    public String getTotal(int index) {
        return driver.findElements(totalSelector).get(index).getText();
    }

}
