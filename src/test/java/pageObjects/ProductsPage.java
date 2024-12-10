package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.UtilLibrary;

public class ProductsPage {

    public static Logger log = LogManager.getLogger(ProductsPage.class);

    String xpath_ItemName = "//*[contains(text(), 'itemName')]";
    String expectedPageTitle = "Products";
    final String invalidCredentialsErrorMsg = "Epic sadface: Username and password do not match any user in this service";
    final String lockedOutUserErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
    WebDriver driver;

    @FindBy(className = "title")
    WebElement label_PageTitle;

    @FindBy(xpath = "//*[text()='"+ invalidCredentialsErrorMsg+"']")
    WebElement InvalidCredentialError;

    @FindBy(xpath = "//*[text()='"+ lockedOutUserErrorMsg+"']")
    WebElement LockedOutUserError;

    @FindBy(id = "add-to-cart")
    WebElement button_AddToCart;

    @FindBy(className = "shopping_cart_link")
    WebElement button_ShoppingCart;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyProductsPage() {
        String actualPageTitle = label_PageTitle.getText();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        log.info("Products page is displayed");
    }

    public void verifyInvalidUserIsUnableToLogin() {
        log.info("User is unable to login due to invalid credentials");
        Assert.assertTrue(InvalidCredentialError.isDisplayed(), "Test failed - Invalid user is able to login");
    }

    public void verifyLockedOutUserIsUnableToLogin() {
        log.info("Locked out user is unable to login");
        Assert.assertTrue(LockedOutUserError.isDisplayed(), "Test failed - Locked out user is able to login");
    }

    public void selectProduct() {
        log.info("Click the product");
        xpath_ItemName = xpath_ItemName.replace("itemName", UtilLibrary.configProperties.getProperty("Item"));
        WebElement elementItem = driver.findElement(By.xpath(xpath_ItemName));
        elementItem.click();
    }

    public void clickAddToCartButton() {
        log.info("click add to cart button");
        button_AddToCart.click();
    }

    public void navigateToShoppingCart() {
        log.info("Click cart icon to navigate to shopping cart");
        button_ShoppingCart.click();
    }
}
