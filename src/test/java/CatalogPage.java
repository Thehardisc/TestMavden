import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CatalogPage extends PetStoreMain {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    // נכנס לקטגוריה לפי שמה (כמו "DOGS", "CATS" וכו')
    public void goToCategory(String categoryName) {
        // בונה את הסלקטור לפי השם
        String categoryUrl = "/categories/" + categoryName.toUpperCase();

        // לוחץ על הקטגוריה המתאימה
        driver.findElement(By.cssSelector("a[href='" + categoryUrl + "']")).click();

        // בדיקה שהגענו לעמוד הנכון
        Assert.assertTrue("Category page not loaded",
                driver.getCurrentUrl().toUpperCase().contains(categoryName.toUpperCase()));
    }
}
