import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

public class CartPage extends PetStoreMain {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // בודק שהעגלה לא ריקה
    public void verifyCartHasItems() {
        List<WebElement> items = driver.findElements(By.cssSelector("#Cart input[type='number']"));
        Assert.assertFalse("Cart is empty", items.isEmpty());
    }

    // מגדיל כמות של פריט רנדומלי בעגלה ולוחץ על Update
    public void increaseRandomItemQuantity() {
        List<WebElement> quantityInputs = driver.findElements(By.cssSelector("#Cart input[type='number']"));
        Assert.assertFalse("No quantity fields found", quantityInputs.isEmpty());

        // בחירה רנדומלית של אחד משדות הכמות
        Random rand = new Random();
        WebElement selectedInput = quantityInputs.get(rand.nextInt(quantityInputs.size()));

        // הגדלת הכמות
        int currentQuantity = Integer.parseInt(selectedInput.getAttribute("value"));
        int newQuantity = currentQuantity + 1;
        selectedInput.clear();
        selectedInput.sendKeys(String.valueOf(newQuantity));

        // לוחץ על כפתור Update Cart
        WebElement updateButton = driver.findElement(By.cssSelector("button[type='submit']"));
        updateButton.click();

        // בדיקה שהכמות עודכנה (אפשר גם לבדוק את המחיר, נרחיב בשלב הבא)
        WebElement updatedInput = driver.findElement(By.name(selectedInput.getAttribute("name")));
        int updatedQuantity = Integer.parseInt(updatedInput.getAttribute("value"));
        Assert.assertEquals("Quantity did not update correctly", newQuantity, updatedQuantity);
    }

    // (אופציונלי) מעבר לצ'קאאוט
    public void proceedToCheckout() {
        WebElement checkoutBtn = driver.findElement(By.cssSelector("a.button[href='/order/newOrderForm']"));
        checkoutBtn.click();
        Assert.assertTrue("Failed to navigate to checkout page", driver.getCurrentUrl().contains("/order/newOrderForm"));
    }
}
