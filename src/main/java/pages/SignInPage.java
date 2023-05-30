package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;
    private By emailField= By.name("email");
    private By continueButton=By.id("continue");
    private By passwordField=By.name("password");
    private By signInButton=By.id("signInSubmit");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(continueButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
