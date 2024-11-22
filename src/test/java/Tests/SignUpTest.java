package Tests;

import org.testng.annotations.*;

@Test
public class SignUpTest extends Base {
    public void navigateToJobSeekerTest(){
    landingPage.navigateToJobSeeker();
    takeScreenshots.takeSnapShot(driver, "Landing Screen");
    }

    @Test(dependsOnMethods = "navigateToJobSeekerTest")
    public void clickFindAJobTest(){
        jobSeekerPage.clickFindJob();
        takeScreenshots.takeSnapShot(driver, "Find A Job Screen");
    }

    @Test(dependsOnMethods = "clickFindAJobTest")
    public void fillSignUpFormTest(){
        signUpPage.fillSignUpForm();
        takeScreenshots.takeSnapShot(driver, "Sign Up Form Screen");

    }

    @Test(dependsOnMethods = "fillSignUpFormTest")
    public void clickTermsCheckboxTest(){
        signUpPage.clickTermsCheckbox();
        takeScreenshots.takeSnapShot(driver, "Checkbox marked");
    }

    @Test(dependsOnMethods = "clickTermsCheckboxTest")
    public void pauseForFewSecondsTest(){
        signUpPage.pauseForFewSeconds();
        takeScreenshots.takeSnapShot(driver, "Completed form Screen");
    }

    @Test(dependsOnMethods = "pauseForFewSecondsTest")
    public void submitFormTest(){
        signUpPage.submitForm();
        takeScreenshots.takeSnapShot(driver, "Submit form");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
