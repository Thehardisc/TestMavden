import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class OrderConfirmationPage extends PetStoreMain {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    // בודק שההזמנה הושלמה בהצלחה לפי טקסט בדף
    public void verifyOrderSuccess() {
        String pageSource = driver.getPageSource().toLowerCase();

        // בדיקת הופעת טקסט שמסמל הצלחה
        boolean containsThankYou = pageSource.contains("thank you");
        boolean containsOrderNumber = pageSource.contains("order") && pageSource.matches(".*order.*#?\\d+.*");

        Assert.assertTrue("Order confirmation not detected on page",
                containsThankYou || containsOrderNumber);
    }
}
