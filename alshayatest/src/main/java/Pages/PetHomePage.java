package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetHomePage extends BasePage {

    public PetHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[class=\"img-responsive\"]")
    WebElement petlogo;

    public void verifyLogo() {
        Boolean islogopresent = (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", petlogo);
        Assert.assertTrue(islogopresent);
    }
}
