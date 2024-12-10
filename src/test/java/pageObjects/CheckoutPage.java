package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {

    public static Logger log = LogManager.getLogger(CheckoutPage.class);

    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement input_FirstName;

    @FindBy(id = "last-name")
    WebElement input_LastName;

    @FindBy(id = "postal-code")
    WebElement input_PostalCode;

    @FindBy(id = "continue")
    WebElement button_Continue;

    @FindBy(id = "finish")
    WebElement button_Finish;

    @FindBy(xpath = "//*[text()='Thank you for your order!']")
    WebElement element_OrderSuccess;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName() {
        log.info("Enter first name");
        input_FirstName.sendKeys("dsfa");
    }

    public void enterLastName() {
        log.info("Enter last name");
        input_LastName.sendKeys("dfasfd");
    }

    public void enterPostalCode() {
        log.info("Enter postal code");
        input_PostalCode.sendKeys("232323");
    }

    public void clickContinueButton() {
        log.info("Click Continue button");
        button_Continue.click();
    }

    public void provideUserInformation() {
        enterFirstName();
        enterLastName();
        enterPostalCode();
    }

    public void clickFinishButton() {
        log.info("Click finish button");
        button_Finish.click();
    }

    public void verifyOrderSuccess() {
        log.info("Verify item order has been placed");
        Assert.assertTrue(element_OrderSuccess.isDisplayed(), "Order has not been placed");
    }
}
