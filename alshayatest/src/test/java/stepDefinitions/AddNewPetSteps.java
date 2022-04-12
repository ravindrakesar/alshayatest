package stepDefinitions;

import Pages.AddNewPetPage;
import Pages.BasePage;
import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AddNewPetSteps extends BasePage {

    @Inject
    AddNewPetPage addNewPetPage;

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

    @When("user clicks on add new pet button")
    public void addnewpet() {
        addNewPetPage.addnewpet();
    }

    @When("user adds {string} pets name")
    public void addpetname(String petname) {
        addNewPetPage.addPetName(petname);
    }

    @When("user adds the pet")
    public void clickAddPetButton() {
        addNewPetPage.addpet();
    }

    @When("user selects pets date of birth as {string}")
    public void selectDateOfBirthOfPet(String dob) {
        addNewPetPage.selectDate(dob);
    }

    @When("user selects type from the dropdown as {string}")
    public void selectTypeFromDropdown(String type) {
        addNewPetPage.selectDropdown(type);
    }

    @Then("user verifies pet name added is {string}")
    public void verifypetname(String petname) {
        addNewPetPage.verifypetnameadded(petname);
    }

    @Then("user verifies pets date of birth as {string}")
    public void verifyuserdob(String dob) {
        addNewPetPage.verifypetdob(dob);
    }
}
