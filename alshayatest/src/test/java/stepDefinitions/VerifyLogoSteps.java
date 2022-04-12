package stepDefinitions;

import Pages.BasePage;
import Pages.PetHomePage;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class VerifyLogoSteps extends BasePage {

    @Inject
    PetHomePage petHomePage;

    @Before
    public void setUp() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            log.info("chrome browser opened");
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/firefoxdriver.exe");
            driver = new FirefoxDriver();
            log.info("firefox browser opened");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scn) {
        if (scn.isFailed()) {
            TakesScreenshot scnShot = (TakesScreenshot) driver;
            byte[] data = scnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/JPEG", "failedScn");
        }
        driver.quit();
    }

    @Then("verify pet logo is displayed")
    public void verifyLogo() {
        petHomePage.verifyLogo();
    }


}
