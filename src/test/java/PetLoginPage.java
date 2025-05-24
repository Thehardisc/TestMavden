import Utils.Config;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class PetLoginPage extends PetStoreMain {

    public PetLoginPage(WebDriver driver) {
        super(driver);
    }

    public PetStoreMain loginUser(String user, String password) {
        WebElement usernameField = this.driver.findElement(By.name("username"));
        WebElement passwordField = this.driver.findElement(By.name("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(user);
        passwordField.sendKeys(password);
        this.driver.findElement(By.xpath("//button[normalize-space(.)='Login']")).click();
        assertPages.assertPages("/","The login failed!");
        return this;
    }
}
