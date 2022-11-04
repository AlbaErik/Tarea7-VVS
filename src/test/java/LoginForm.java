import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    @FindBy(id = "user-name")
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
    public void loginWithCorrectdata(){
        enterUsername("dumbridge");
        enterPassword("tomriddle");
        pressLoginButton();

    }
    public void loginWithUserName(){
        enterUsername("dumbridge");
        enterPassword("qwergds");
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