import Utils.Config;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetRegisterPage extends PetStoreMain {

    public PetRegisterPage(WebDriver driver) {
        super(driver);
    }

    public PetLoginPage registerUser(String user, String pass) {
        this.driver.findElement(By.name("username")).sendKeys(user);
        this.driver.findElement(By.name("password")).sendKeys(pass);
        this.driver.findElement(By.name("repeatedPassword")).sendKeys(pass);

        this.driver.findElement(By.name("firstName")).sendKeys("Andrey");
        this.driver.findElement(By.name("lastName")).sendKeys("Tester");
        this.driver.findElement(By.name("email")).sendKeys("test@example.com");
        this.driver.findElement(By.name("phone")).sendKeys("0501234567");
        this.driver.findElement(By.name("address1")).sendKeys("Egged St 104");
        this.driver.findElement(By.name("address2")).sendKeys("Egged St 104");
        this.driver.findElement(By.name("city")).sendKeys("Tel Aviv");
        this.driver.findElement(By.name("state")).sendKeys("TA");
        this.driver.findElement(By.name("zip")).sendKeys("6100000");
        this.driver.findElement(By.name("country")).sendKeys("Israel");

        this.driver.findElement(By.name("languagePreference")).sendKeys("english");
        this.driver.findElement(By.name("favouriteCategoryId")).sendKeys("DOGS");

        this.driver.findElement(By.name("listOption")).click();
        this.driver.findElement(By.name("bannerOption")).click();

        this.driver.findElement(By.xpath("//button[normalize-space(.)='Save Account Information']")).click();
        this.assertPages.assertPages(this.config.getLoginUriAfterRegister(),"Something went Wrong in the registeration");
        return new PetLoginPage(this.driver);

    }

}
