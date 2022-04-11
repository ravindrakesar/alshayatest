package stepDefinitions;

import Pages.BasePage;
import Pages.PetHomePage;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;

public class VerifyLogoSteps extends BasePage {

    @Inject
    PetHomePage petHomePage;

    @Then("verify pet logo is displayed")
    public void verifyLogo() {
        petHomePage.verifyLogo();
    }


}
