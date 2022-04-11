package stepDefinitions;

import Pages.AddNewPetPage;
import Pages.BasePage;
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewPetSteps extends BasePage {

    @Inject
    AddNewPetPage addNewPetPage;

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
