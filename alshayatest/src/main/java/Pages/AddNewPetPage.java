package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewPetPage extends BasePage {

    @FindBy(partialLinkText = "Add New Pet")
    WebElement addnewpet;

    @FindBy(partialLinkText = "Add pet")
    WebElement addpet;

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement petname;

    @FindBy(xpath = "//*[@id=\"birthDate\"]")
    WebElement petbirthdate;

    @FindBy(xpath = "//*[@id=\"type\"]")
    WebElement pettype;

    @FindBy(xpath = "/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]")
    WebElement petnameexpected;

    @FindBy(xpath = "/html/body/div/div/table[2]/tbody/tr/td[1]/dl/dd[1]")
    WebElement petdobexpected;

    public AddNewPetPage() {
        PageFactory.initElements(driver, this);
    }

    public void addnewpet() {
        addnewpet.click();
    }

    public void addPetName(String searchtext) {
        petname.sendKeys(searchtext);
    }

    public void addpet() {
        addpet.click();
    }

    public void selectDate(String dob) {
        petbirthdate.sendKeys(dob);
    }

    public void selectDropdown(String type) {
        Select pet = new Select(pettype);
        pet.selectByVisibleText(type);
    }

    public void verifypetnameadded(String petname) {
        petnameexpected.getText().equalsIgnoreCase(petname);
    }

    public void verifypetdob(String dob) {
        petdobexpected.getText().equalsIgnoreCase(dob);
    }
}