package Utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AssertPages {
    private final WebDriver driver;

    public AssertPages(WebDriver driver) {
        this.driver = driver;
    }

    public void assertPages(String uri, String errorMessage) {
        String expectedUrl = Config.getInstance().getWebSiteUrl() + uri;
        try {
            new FluentWait<>(this.driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .until(d -> d.getCurrentUrl().equals(expectedUrl));
        } catch (Exception e) {
            Assert.fail(errorMessage);
        }
    }

    public void assertHTML(String value, String errorMessage) {
        try {
            new FluentWait<>(this.driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .until(d -> d.findElement(By.xpath(value)).isDisplayed());

        } catch (Exception e) {
            Assert.fail(errorMessage);
        }
    }
}
