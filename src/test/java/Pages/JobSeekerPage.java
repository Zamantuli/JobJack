package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobSeekerPage {
    public WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//a[contains(.,'Find a job')])[3]")
    WebElement findAJob;

    public JobSeekerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickFindJob() {
        findAJob.click();
    }
}
