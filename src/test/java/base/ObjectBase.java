package base;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.UtilLibrary;

public class ObjectBase {

    protected WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    UtilLibrary utils;

    ObjectBase() {
        driver = new WebDriverBase().getDriver();
    }

    public LoginPage getLoginPage() {
        return loginPage == null ? loginPage = new LoginPage(driver) : loginPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage == null ? productsPage = new ProductsPage(driver) : productsPage;
    }

    public CartPage getCartPage() {
        return cartPage == null ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage == null ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }

    public void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }

}
