import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends PetStoreMain {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage verifyOnCheckoutPage() {
        assertPages.assertPages("/order/newOrderForm", "Not on the checkout form page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form[action*='newOrder']")));
        return this;
    }

    public ConfirmationPage continueToOrderConfirmation() {
        this.driver.findElement(By.xpath("//button[@type='submit' and normalize-space(text())='Continue']")).click();
        assertPages.assertPages("/order/newOrder", "Not on the checkout form page");
        return new ConfirmationPage(this.driver);
    }
}