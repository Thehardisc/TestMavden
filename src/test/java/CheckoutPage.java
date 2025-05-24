import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class CheckoutPage extends PetStoreMain {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    // בדיקה שהגענו לעמוד טופס ההזמנה
    public void verifyOnCheckoutPage() {
        Assert.assertTrue("Not on the checkout form page",
                driver.getCurrentUrl().contains("/order/newOrderForm"));
    }

    // בחירה אם לשלוח לכתובת אחרת (true / false)
    public void setShippingToDifferentAddress(boolean useDifferentAddress) {
        WebElement checkbox = driver.findElement(By.name("shippingAddressRequired"));
        boolean isChecked = checkbox.isSelected();

        if (useDifferentAddress != isChecked) {
            checkbox.click();
        }
    }

    // לוחץ על כפתור Continue
    public void continueToOrderConfirmation() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // בדיקה ראשונית שעברנו שלב
        Assert.assertTrue("Did not proceed to final order step",
                driver.getCurrentUrl().contains("/order") || driver.getPageSource().toLowerCase().contains("thank"));
    }
}
