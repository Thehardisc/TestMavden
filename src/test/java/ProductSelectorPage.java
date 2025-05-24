import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductSelectorPage extends PetStoreMain {

    public ProductSelectorPage(WebDriver driver) {
        super(driver);
    }

    public AddToCartPage selectRandomProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#Catalog")));
        List<WebElement> productLinks = this.driver.findElements(By.cssSelector("#Catalog a[href*='/products/']"));
        if (productLinks.isEmpty()) {
            Assert.fail("No products found");
        }
        WebElement selectedLink = productLinks.get(new Random().nextInt(productLinks.size()));
        String expectedHref = selectedLink.getAttribute("href");
        selectedLink.click();
        String uri = expectedHref.replace(config.getWebSiteUrl(), "");
        assertPages.assertPages(
                uri,
                "Failed to navigate to product page"
        );
        return new AddToCartPage(this.driver);
    }
}