import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PetStoreMain {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verify on checkout form page
     */
    public CheckoutPage verifyOnCheckoutPage() {
        assertPages.assertPages(
                "/order/newOrderForm",
                "Not on the checkout form page"
        );
        return this;
    }

    /**
     * Submit the order form and verify confirmation step
     */
    public OrderConfirmationPage continueToOrderConfirmation() {
        driver.findElement(By.cssSelector("button[type='submit']"))
                .click();
        assertPages.assertHTML(
                "//h1[contains(normalize-space(.),'Thank You') or " +
                        "contains(normalize-space(.),'Order Confirmation')]",
                "Did not proceed to final order step"
        );
        return new OrderConfirmationPage(driver);
    }
}
