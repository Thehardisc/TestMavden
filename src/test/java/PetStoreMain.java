import Utils.AssertPages;
import Utils.Config;
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

    public ProductSelectorPage goToFishCategory() {
        this.driver.findElement(By.cssSelector("a[href='/categories/FISH']")).click();
        assertPages.assertPages(
                "/categories/FISH",
                "Fish category page not loaded"
        );
        return new ProductSelectorPage(this.driver);
    }

    public PetRegisterPage register() {
        this.driver.findElement(By.cssSelector("a[href='/account/newAccountForm']")).click();
        assertPages.assertPages(
                config.getRegisterUri(),
                "The Register button has failed to move you to the register page"
        );
        return new PetRegisterPage(this.driver);
    }

    public PetEditAccount editProfile() {
        this.driver.findElement(By.cssSelector("a[href='/account/editAccountForm']")).click();
        assertPages.assertPages(
                config.getEditAccountUri(),
                "The Edit Profile button has failed to move you to the edit Account page"
        );
        return new PetEditAccount(this.driver);
    }

    public PetLoginPage login() {
        this.driver.findElement(By.cssSelector("a[href='/account/signonForm']")).click();
        assertPages.assertPages(
                config.getLoginUrl(),
                "The login redirection failed!"
        );
        return new PetLoginPage(this.driver);
    }

    public PetStoreMain logoff() {
        this.driver.findElement(By.cssSelector("a[href='/account/signoff']")).click();
        assertPages.assertPages(
                "/",
                "The logoff failed!"
        );
        return this;
    }
}