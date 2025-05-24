import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends PetStoreMain {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage verifyOrderSuccess() {
        assertPages.assertHTML(
                "//p[normalize-space(text())='Thank you, your order has been submitted.']",
                "Order submission confirmation not displayed"
        );
        return this;
    }
}