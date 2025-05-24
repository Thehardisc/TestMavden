import Utils.AssertPages;
import Utils.Config;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PetStoreMain {
    protected final WebDriver driver;
    protected final Config config;
    protected final AssertPages assertPages;

    public PetStoreMain(WebDriver driver) {
        this.driver = driver;
        this.config = Config.getInstance();
        this.assertPages = new AssertPages(driver);
    }

    public PetStoreMain open() {
        this.driver.get(this.config.getWebSiteUrl());
        return this;
    }

    public PetRegisterPage register() {
        driver.findElement(By.cssSelector("a[href='/account/newAccountForm']"))
                .click();
        assertPages.assertPages(
                config.getRegisterUri(),
                "The Register button has failed to move you to the register page"
        );
        return new PetRegisterPage(driver);
    }

    public PetEditAccount editProfile() {
        driver.findElement(By.cssSelector("a[href='/account/editAccountForm']"))
                .click();
        assertPages.assertPages(
                config.getEditAccountUri(),
                "The Edit Profile button has failed to move you to the edit Account page"
        );
        return new PetEditAccount(driver);
    }

    public PetLoginPage login() {
        driver.findElement(By.cssSelector("a[href='/account/signonForm']"))
                .click();
        assertPages.assertPages(
                config.getLoginUrl(),
                "The login redirection failed!"
        );
        return new PetLoginPage(driver);
    }

    public PetStoreMain logoff() {
        driver.findElement(By.cssSelector("a[href='/account/signoff']"))
                .click();
        assertPages.assertPages(
                "/",
                "The logoff failed!"
        );
        return this;
    }
}
