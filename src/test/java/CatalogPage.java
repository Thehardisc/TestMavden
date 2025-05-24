import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends PetStoreMain {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to the given category and verify the URL
     */
    public CatalogPage goToCategory(String categoryName) {
        String categoryUrl = "/categories/" + categoryName.toUpperCase();
        driver.findElement(By.cssSelector("a[href='" + categoryUrl + "']")).click();
        assertPages.assertPages(
                categoryUrl,
                "Category page not loaded"
        );
        return this;
    }
}
