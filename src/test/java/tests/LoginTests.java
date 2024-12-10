package tests;

import base.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void verifyValidUserLogin() {
        app.getLoginPage().enterUsername();
        app.getLoginPage().enterPassword();
        app.getLoginPage().clickLogin();
        app.getProductsPage().verifyProductsPage();
    }

    @Test
    public void verifyInvalidCredentialLoginFailure() {
        app.getLoginPage().enterUsername();
        app.getLoginPage().enterPassword();
        app.getLoginPage().clickLogin();
        app.getProductsPage().verifyInvalidUserIsUnableToLogin();
    }

    @Test
    public void verifyLockedOutUserLoginFailure() {
        app.getLoginPage().enterUsername();
        app.getLoginPage().enterPassword();
        app.getLoginPage().clickLogin();
        app.getProductsPage().verifyLockedOutUserIsUnableToLogin();
    }
}
