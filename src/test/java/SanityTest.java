import Utils.Config;
import Utils.UserRandomizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SanityTest {
    private WebDriver driver;
    private PetStoreMain petStore;
    private Config config;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.petStore = new PetStoreMain(this.driver);
        this.config = Config.getInstance();
    }

    @Test
    public void sanityTest() {
        UserRandomizer randomizer = UserRandomizer.getInstance();
        String user = randomizer.generateUsername();
        String staticPassword = this.config.getStaticPassword();
        this.petStore
                .open()
                .register()
                .registerUser(user, staticPassword)
                .loginUser(user, staticPassword)
                .goToFishCategory()
                .selectRandomProduct()
                .clickRandomAddToCart()
                .verifyCartHasItems()
                .proceedToCheckout()
                .verifyOnCheckoutPage()
                .continueToOrderConfirmation()
                .confirmOrder()
                .verifyOrderSuccess()
                .editProfile()
                .changePassword()
                .logoff()
                .login()
                .loginUser(user, randomizer.getGeneratedPassword());
    }

    @After
    public void tearDown() {
        this.driver.quit();
        System.out.println("The Sanity test Finished!");
    }
}