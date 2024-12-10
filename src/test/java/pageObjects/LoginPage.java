package pageObjects;

import base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.UtilLibrary;

public class LoginPage {
    public static Logger log = LogManager.getLogger(LoginPage.class);

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement input_username;

    @FindBy(id = "password")
    WebElement input_password;

    @FindBy(id = "login-button")
    WebElement button_login;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername() {
        String username = UtilLibrary.configProperties.getProperty("Username");
        log.info("Enter username : " + username);
        input_username.sendKeys(username);
    }

    public void enterPassword() {
        String password = UtilLibrary.configProperties.getProperty("Password");
        log.info("Enter Password : " + password);
        input_password.sendKeys(password);
    }

    public void clickLogin() {
        log.info("Click login button");
        button_login.click();
    }

    public void verifyLoginPage(){
        Assert.assertTrue(button_login.isDisplayed());
        log.info("Login page is displayed");
    }

    public void loginToApp() {
        enterUsername();
        enterPassword();
        clickLogin();
    }
}
