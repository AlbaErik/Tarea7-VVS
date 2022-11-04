import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Case 1: Login with no data")
    public static void loginWithNoData(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.loginWithNodata();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        InitPage productPage = new InitPage(driver);
        Assert.assertEquals(productPage.getState(), "Atención: Debe ingresar un nombre de usuario");
    }

    @Test(testName = "Case 2: Login with username and no more")
    public static void loginUserName(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.loginWithJustUserName();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        InitPage productPage = new InitPage(driver);
        Assert.assertEquals(productPage.getState(), "Atención: El password no puede estar vació");
    }

    @Test(testName = "Case 3: Login successfully")
    public static void loginSuccesfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.loginWithCorrectdata();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        InitPage productPage = new InitPage(driver);
        Assert.assertEquals(productPage.getTitle(), "Bienvenido a OSTH On-Line");

    }

    @Test(testName = "Case 4: Login with wrong password")
    public static void loginWrongPassword(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.loginWithWrongPass();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        InitPage productPage = new InitPage(driver);
        Assert.assertEquals(productPage.getState(), "Atención: El password ingresado no es válido");
    }

    @AfterTest
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}