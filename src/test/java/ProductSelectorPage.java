import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class ProductSelectorPage extends PetStoreMain {

    public ProductSelectorPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Select a random product and verify navigation
     */
    public ProductSelectorPage selectRandomProduct() {
        List<WebElement> productLinks =
                driver.findElements(By.cssSelector("#Catalog table a"));
        WebElement selectedLink =
                productLinks.get(new Random().nextInt(productLinks.size()));
        String expectedHref = selectedLink.getAttribute("href");

        selectedLink.click();
        // extract relative URI
        String uri = expectedHref.replace(config.getWebSiteUrl(), "");
        assertPages.assertPages(
                uri,
                "Failed to navigate to product page"
        );
        return this;
    }
}
