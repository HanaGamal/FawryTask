package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    private By cartNumber= By.xpath("//span[@id='nav-cart-count']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }
    public int getcartNumber(){
        int num=Integer.parseInt(driver.findElement(cartNumber).getText());
        return num;
    }
}
