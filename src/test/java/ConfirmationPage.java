import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends PetStoreMain {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public OrderConfirmationPage confirmOrder() {
        assertPages.assertHTML("//button[@type='submit' and normalize-space(text())='Confirm']","The Confirm page is missing!");
        this.driver.findElement(By.xpath("//button[@type='submit' and normalize-space(text())='Confirm']")).click();
        assertPages.assertHTML(
                "//p[normalize-space(text())='Thank you, your order has been submitted.']",
                "Order submission confirmation not displayed"
        );
        return new OrderConfirmationPage(this.driver);
    }
}
