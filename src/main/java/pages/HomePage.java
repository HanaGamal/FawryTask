package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private By signInHover=By.id("nav-link-accountList-nav-line-1");
    private By signInButton=By.className("nav-action-inner");
    private By allButton=By.className("hm-icon-label");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private void Hover(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }


    public void hoverSignIn(){
        Hover(driver.findElement(signInHover));

    }
    public SignInPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
    public MenuPage selectAll(){
        WebElement link2=wait.until(ExpectedConditions.visibilityOfElementLocated(allButton));
        link2.click();
        return new MenuPage(driver);
    }
}
