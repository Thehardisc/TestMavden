import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class AddToCartPage extends PetStoreMain {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickRandomAddToCart() {
        assertPages.assertText("a.button[href*='addItemToCart']","The list is empty");
        List<WebElement> buttons = this.driver.findElements(By.cssSelector("a.button[href*='addItemToCart']"));
        if (buttons.isEmpty()) {
            throw new RuntimeException("No 'Add to Cart' buttons found on the product page!");
        }
        WebElement randomButton = buttons.get(new Random().nextInt(buttons.size()));
        randomButton.click();
        assertPages.assertPages(
                "/cart/viewCart",
                "Did not navigate to cart after adding item"
        );
        return new CartPage(this.driver);
    }
}