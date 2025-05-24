import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

public class ProductSelectorPage extends PetStoreMain {

    public ProductSelectorPage(WebDriver driver) {
        super(driver);
    }

    // בוחר מוצר רנדומלי מתוך הטבלה ומעביר לעמוד שלו
    public void selectRandomProduct() {
        // מאתר את כל הקישורים למוצרים בטבלה תחת div#Catalog
        List<WebElement> productLinks = driver.findElements(By.cssSelector("#Catalog table a"));

        // בדיקה שהטבלה לא ריקה
        Assert.assertFalse("No products found in the catalog page", productLinks.isEmpty());

        // בחירת אינדקס רנדומלי
        Random rand = new Random();
        int randomIndex = rand.nextInt(productLinks.size());

        // לוקח את הקישור ובודק את הכתובת
        WebElement selectedLink = productLinks.get(randomIndex);
        String expectedHref = selectedLink.getAttribute("href");

        // לוחץ על הקישור
        selectedLink.click();

        // בדיקה שהעברנו לעמוד מוצר
        Assert.assertTrue("Failed to navigate to product page",
                driver.getCurrentUrl().contains("/products/") || driver.getCurrentUrl().equals(expectedHref));
    }
}
