import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitPage extends PageObject{
    @FindBy(id = "estado")
    private WebElement mensaje;
    public InitPage(WebDriver driver) {
        super(driver);
    }

    public String getState(){
        return this.mensaje.getText();
    }
}
