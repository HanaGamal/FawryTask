package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private By seeAllButton=By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']//div[text()='see all']");
    private By videoGames=By.xpath("//a[@class='hmenu-item']//div[text()='Video Games']");
    private By allVideoGames=By.xpath("//a[@class='hmenu-item' and text()='All Video Games']");

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }
    public void selectSeeAllButton(){

        By content=By.id("hmenu-content");

        WebElement link2 = wait.until(ExpectedConditions.visibilityOfElementLocated(content));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",link2);
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllButton));

        link.click();
    }
    public VideoGamesPage selectAllVideoGames(){
        WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(videoGames));
        link.click();
        WebElement link2=wait.until(ExpectedConditions.visibilityOfElementLocated(allVideoGames));
        link2.click();
        return new VideoGamesPage(driver);
    }
}
