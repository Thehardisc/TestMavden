import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

public class AddToCartPage extends PetStoreMain {
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    // מאתר קישורי Add to Cart ולוחץ על אחד רנדומלי
    public void clickRandomAddToCart() {
        // מאתר את כל הכפתורים עם class="button" שמובילים לסל
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("a.button[href*='addItemToCart']"));

        // בדיקה שיש כפתורים
        Assert.assertFalse("No Add to Cart buttons found", addToCartButtons.isEmpty());

        // בחירה רנדומלית
        Random rand = new Random();
        WebElement randomButton = addToCartButtons.get(rand.nextInt(addToCartButtons.size()));

        // שמירת קישור לצורך בדיקה
        String expectedUrl = randomButton.getAttribute("href");

        // לחיצה
        randomButton.click();

        // בדיקה שאנחנו בעמוד הסל
        Assert.assertTrue("Did not navigate to cart after adding item",
                driver.getCurrentUrl().contains("/cart"));
    }
}
