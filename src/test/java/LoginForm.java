import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{
    private final String USERNAME="dumbridge";
    private final String PASSWORD="tomriddle";
    private final String INVALID_PASSWORD="dsfg";

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_button;


    public LoginForm(WebDriver driver){
        super(driver);
    }

    public void loginWithNodata(){
        enterUsername("");
        enterPassword("");
        pressLoginButton();
    }

    public void loginWithJustUserName(){
        enterUsername(USERNAME);
        enterPassword("");
        pressLoginButton();
    }

    public void loginWithCorrectdata(){
        enterUsername(USERNAME);
        enterPassword(PASSWORD);
        pressLoginButton();

    }
    public void loginWithWrongPass(){
        enterUsername(USERNAME);
        enterPassword(INVALID_PASSWORD);
        pressLoginButton();
    }

    private void enterUsername(String cad){
        this.username.sendKeys(cad);
    }

    private void enterPassword(String cad){
        this.password.sendKeys(cad);
    }

    private void pressLoginButton(){
        this.login_button.click();
    }

}