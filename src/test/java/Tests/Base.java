package Tests;

import Pages.*;
import Utils.BrowserFactory;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.jobjack.co.za/");
    LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    JobSeekerPage jobSeekerPage = PageFactory.initElements(driver, JobSeekerPage.class);
    SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    TakeScreenshots takeScreenshots = new TakeScreenshots();
}