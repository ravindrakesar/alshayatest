package stepDefinitions;

import Pages.BasePage;
import Pages.AddOwnerPage;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AddOwnerSteps extends BasePage {

    @Inject
    AddOwnerPage addOwnerPage;

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

    @Given("User navigates to petclinic homepage")
    public void user_navigates_to_petclinic_page() {
        String title = addOwnerPage.validateWelcomePageTitle();
        Assert.assertEquals("valid page title", "PetClinic :: a Spring Framework demonstration", title);
    }

    @When("user clicks on find owner button")
    public void findcustomerbutton() {
        addOwnerPage.clickFindOwner();
    }

    @When("user clicks on add owner button")
    public void addownerbutton() {
        addOwnerPage.clickAddOwner();
    }

    @When("user enters {string} as firstname")
    public void userEnterFirstName(String searchtext) {
        addOwnerPage.addFirstName(searchtext);
    }

    @When("user enters {string} as lastname")
    public void userEnterLastName(String searchtext) {
        addOwnerPage.addLastName(searchtext);
    }

    @When("user enters {string} as address")
    public void userEntersAddress(String searchtext) {
        addOwnerPage.addAddress(searchtext);
    }

    @When("user enters {string} as city")
    public void userEntersCity(String searchtext) {
        addOwnerPage.addCity(searchtext);
    }

    @When("user enters {string} as telephone")
    public void userEntersTelephone(String searchtext) {
        addOwnerPage.addTelephone(searchtext);
    }

    @When("user submits the form")
    public void usersubmitstheform() {
        addOwnerPage.submitform();
    }

    @Then("verify user's firstname is {string}")
    public void verifyFullname() {
        addOwnerPage.verifyFullName();
    }

    @Then("verify user's address is {string}")
    public void verifyAddress() {
        addOwnerPage.verifyAddress();
    }

    @Then("verify user's city is {string}")
    public void verifyCityName() {
        addOwnerPage.verifyCityName();
    }

    @Then("verify user's telephone number is {string}")
    public void verifyTelephone() {
        addOwnerPage.verifyTelephoneNumber();
    }


}
