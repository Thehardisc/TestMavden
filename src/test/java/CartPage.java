import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class CartPage extends PetStoreMain {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify cart has at least one item and update quantity
     */
    public CartPage verifyCartHasItems() {
        List<WebElement> items =
                driver.findElements(By.cssSelector("#Cart input[type='number']"));
        if (items.isEmpty()) {
            throw new AssertionError("Cart is empty");
        }
        // update a random item's quantity
        WebElement selectedInput =
                items.get(new Random().nextInt(items.size()));
        int newQuantity = new Random().nextInt(5) + 1;
        selectedInput.clear();
        selectedInput.sendKeys(String.valueOf(newQuantity));

        WebElement updatedInput =
                driver.findElement(By.name(selectedInput.getAttribute("name")));
        int updatedQuantity =
                Integer.parseInt(updatedInput.getAttribute("value"));
        if (updatedQuantity != newQuantity) {
            throw new AssertionError("Quantity did not update correctly");
        }
        return this;
    }

    /**
     * Proceed to checkout and verify URL
     */
    public CheckoutPage proceedToCheckout() {
        driver.findElement(
                By.cssSelector("a.button[href='/order/newOrderForm']")
        ).click();
        assertPages.assertPages(
                "/order/newOrderForm",
                "Failed to navigate to checkout page"
        );
        return new CheckoutPage(driver);
    }
}
