import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends PetStoreMain {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage verifyCartHasItems() {
        assertPages.assertText("#Cart", "Cart table did not appear on the page");

        int totalRows = driver
                .findElement(By.cssSelector("#Cart"))
                .findElements(By.cssSelector("tr"))
                .size();
        int itemCount = totalRows - 1;

        if (itemCount < 1) {
            Assert.fail("Cart is empty; expected at least one item but found " + itemCount);
        }

        return this;
    }

    public CheckoutPage proceedToCheckout() {
        assertPages.assertText("a[href='/order/newOrderForm']", "Didn't found the checkout button");
        driver.findElement(By.cssSelector("a[href='/order/newOrderForm']")).click();
        assertPages.assertPages(
                "/order/newOrderForm",
                "Did not navigate to checkout page"
        );
        return new CheckoutPage(this.driver);
    }
}