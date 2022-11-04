import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitPage extends PageObject{
    @FindBy(id = "estado")
    private WebElement mensaje;

    @FindBy(xpath = "//span[contains(text(),'Bienvenido a OSTH On-Line')]")
    private WebElement init_label;
    public InitPage(WebDriver driver) {
        super(driver);
    }

    public String getState(){
        return this.mensaje.getText();
    }

    public String getTitle(){
        return this.init_label.getText();
    }
}
