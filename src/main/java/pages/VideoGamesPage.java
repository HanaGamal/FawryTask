package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VideoGamesPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private By freeShipping= By.xpath("//span[text()='Free Shipping']");
    private By newButton=By.xpath("//span[text()='New']");
    private By sorting=By.className("a-dropdown-label");

    private By prices=By.xpath("//div[@class='sg-col-inner']//span[@class='a-price']//span[@class='a-price-whole']");

    private By shoppingCart=By.xpath("//span[@class='nav-cart-icon nav-sprite']");
    public VideoGamesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void filter(){
        driver.findElement(freeShipping).click();
        WebElement newLink=wait.until(ExpectedConditions.visibilityOfElementLocated(newButton));
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        newLink.click();
    }

    public void sortBy(){
        Select select=new Select(driver.findElement(sorting));
        select.selectByVisibleText("Price: High to Low");
    }

    public int checkPrice(){
        List <WebElement> allprices=driver.findElements(prices);
        int[] pricess = new int[allprices.size()];
        String numberString;
        int number;
        for(int i=0;i<allprices.size();i++){
            numberString=allprices.get(i).getText();
            numberString = numberString.replace(",", ""); // Remove the comma from the string
            number = Integer.parseInt(numberString);
            if(number<15000){
                pricess[i]=number;
                allprices.get(i).click();
                driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
                driver.navigate().back();
                driver.navigate().back();
            }
        }
        if(pricess.length==0){
            driver.findElement(By.xpath("//a[@aria-label='Go to next page, page 2']")).click();
        }
        return pricess.length;
    }
    public ShoppingCartPage clickShoppingCart(){
        driver.findElement(shoppingCart).click();
        return new ShoppingCartPage(driver);
    }
}
