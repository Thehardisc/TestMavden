import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class AddToCartPage extends PetStoreMain {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click a random "Add to Cart" button and verify navigation
     */
    public CartPage clickRandomAddToCart() {
        List<WebElement> buttons =
                driver.findElements(By.cssSelector("a.button[href*='/cart']"));
        WebElement randomButton =
                buttons.get(new Random().nextInt(buttons.size()));
        randomButton.click();
        assertPages.assertPages(
                "/cart",
                "Did not navigate to cart after adding item"
        );
        return new CartPage(driver);
    }
}
