package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(.,'Job seekers')]")
    WebElement jobSeeker;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateToJobSeeker() {
        wait.until(ExpectedConditions.elementToBeClickable(jobSeeker)).click();
    }
}
