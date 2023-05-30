import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.amazon.eg/");
        homePage=new HomePage(driver);
    }
    @Test
    public void TestScenario()
    {
        homePage.hoverSignIn();
        SignInPage signInPage=homePage.clickSignIn();
        signInPage.signIn("Hanagamal98@outlook.com","hana1234");
        MenuPage menuPage=homePage.selectAll();
        menuPage.selectSeeAllButton();
        VideoGamesPage videoGamesPage=menuPage.selectAllVideoGames();
        videoGamesPage.filter();
        videoGamesPage.sortBy();
        int itemsadded=videoGamesPage.checkPrice();
        ShoppingCartPage cartPage=videoGamesPage.clickShoppingCart();
        int cartItems=cartPage.getcartNumber();
        Assert.assertEquals(itemsadded,cartItems);


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
