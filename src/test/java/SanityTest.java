import Utils.Config;
import Utils.UserRandomizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;


public class SanityTest {
    private WebDriver driver;
    private PetStoreMain petStore;
    private Config config;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.petStore = new PetStoreMain(driver);
    }

    @Test
    public void sanityTest() {
        String user = UserRandomizer.getInstance().generateUsername();
        this.config = Config.getInstance();

        this.petStore
                .open()
                .register()
                .registerUser(user,this.config.getStaticPassword())
                .loginUser(user,this.config.getStaticPassword())
                .editProfile()
                .changePassword()
                .logoff()
                .login()
                .loginUser(user,UserRandomizer.getInstance().getGeneratedPassword());
    }

    @After
    public void tearDown() {
        System.out.println("The Sanity test Finished!");
    }

}
