package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SignUpPage {
    public WebDriver driver;
    WebDriverWait wait;

    Faker faker = new Faker();

    String locationInput = "Ve";
    String locationToSelect = "Ve";

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    WebElement firstNameTextField;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    WebElement lastNameTextField;

    @FindBy(xpath = "//input[@formcontrolname='RSAID']")
    WebElement rsaIDNumberTextField;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    WebElement phoneNumberTextField;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailAddressTextField;

    @FindBy(xpath = "(//div[@role='combobox'])[1]")
    WebElement whatsAppNumber;

    @FindBy(xpath = "(//div[@role='option'])[1]")
    WebElement whatsAppOptions;

    @FindBy(xpath = "(//div[@role='combobox'])[2]")
    WebElement whatsAppNotifications;

    @FindBy(xpath = "//span[contains(.,'Yes')]")
    WebElement whatsAppNotificationOption;

    @FindBy(xpath = "(//input[contains(@type,'text')])[6]")
    WebElement location;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath = "(//div[@role='combobox'])[4]")
    WebElement marketingChannel;

    @FindBy(xpath = "//span[contains(.,'Radio')]")
    WebElement marketingChannelOption;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsAndConditions;

    @FindBy(xpath = "//button[contains(.,'Register')]")
    WebElement submitInfo;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void fillSignUpForm(){
        firstNameTextField.sendKeys(faker.name().firstName());
        lastNameTextField.sendKeys(faker.name().lastName());

        rsaIDNumberTextField.sendKeys(faker.number().digits(13));

        phoneNumberTextField.sendKeys(faker.phoneNumber().cellPhone());
        emailAddressTextField.sendKeys(faker.internet().emailAddress());

        whatsAppNumber.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whatsAppOptions);
        whatsAppOptions.click();

        whatsAppNotifications.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Yes')])")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whatsAppNotificationOption);
        whatsAppNotificationOption.click();

        if (locationInput == null || locationToSelect == null || locationInput.isEmpty() || locationToSelect.isEmpty()) {
            throw new IllegalArgumentException("Input values cannot be null or empty");
        }
        location.click();
        location.sendKeys(locationInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Vereeniging, Gauteng, South Africa')])")));
        WebElement locationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'" + locationToSelect + "')]")));
        locationOption.click();

        passwordTextField.sendKeys("Register");

        marketingChannel.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", marketingChannelOption);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(.,'Radio')])")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", marketingChannelOption);
        marketingChannelOption.click();
    }

    public void clickTermsCheckbox(){
        termsAndConditions.click();
    }

    public void pauseForFewSeconds(){
        try {
            // Pause for 30 seconds
            Thread.sleep(30000); // Time in milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void submitForm(){
        submitInfo.click();
    }
}