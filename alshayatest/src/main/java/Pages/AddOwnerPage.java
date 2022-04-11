package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOwnerPage extends BasePage {

    @FindBy(partialLinkText = "find owners")
    WebElement findowners;
    @FindBy(partialLinkText = "Add Owner")
    WebElement addowner;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    WebElement firstname;
    @FindBy(xpath = "//*[@id=\"lastName\"]")
    WebElement lastname;
    @FindBy(xpath = "//*[@id=\"address\"]")
    WebElement address;
    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement city;
    @FindBy(xpath = "//*[@id=\"telephone\"]")
    WebElement telephone;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement submit;

    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[1]/td/b")
    WebElement fullname;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[2]/td")
    WebElement verifyaddress;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[3]/td")
    WebElement verifycity;
    @FindBy(xpath = "/html/body/div/div/table[1]/tbody/tr[4]/td")
    WebElement verifytelephone;

    public AddOwnerPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateWelcomePageTitle() {
        return driver.getTitle();
    }

    public void clickFindOwner() {
        findowners.click();
    }

    public void clickAddOwner() {
        addowner.click();
    }

    public void addFirstName(String searchtext) {
        firstname.sendKeys(searchtext);
    }

    public void addLastName(String searchtext) {
        lastname.sendKeys(searchtext);
    }

    public void addAddress(String searchtext) {
        address.sendKeys("JPNAGAR");
    }

    public void addCity(String searchtext) {
        city.sendKeys("Bangalore");
    }

    public void addTelephone(String searchtext) {
        telephone.sendKeys("7019882661");
    }

    public void submitform() {
        submit.click();
    }

    public void verifyFullName() {
        fullname.isDisplayed();
    }

    public void verifyAddress() {
        verifyaddress.isDisplayed();
    }

    public void verifyCityName() {
        verifycity.isDisplayed();
    }

    public void verifyTelephoneNumber() {
        verifytelephone.isDisplayed();
    }

}
