import Utils.Config;
import Utils.UserRandomizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetEditAccount extends PetStoreMain {

    public PetEditAccount(WebDriver driver) {
        super(driver);
    }

    public PetEditAccount changePassword() {
        String newPass = UserRandomizer.getInstance().generatePassword();
        this.driver.findElement(By.name("password")).sendKeys(newPass);
        this.driver.findElement(By.name("repeatedPassword")).sendKeys(newPass);

        this.driver.findElement(By.xpath("//button[normalize-space(.)='Save Account Information']")).click();

        assertPages.assertHTML("//p[normalize-space(text())='Your account has been updated.']","Failed to update the password!");
        return this;
    }

}
