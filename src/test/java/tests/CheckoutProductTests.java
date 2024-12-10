package tests;

import base.TestBase;
import org.testng.annotations.Test;

public class CheckoutProductTests extends TestBase {

    @Test
    public void placeOrderForAProduct() {
        app.getLoginPage().loginToApp();
        app.getProductsPage().selectProduct();
        app.getProductsPage().clickAddToCartButton();
        app.getProductsPage().navigateToShoppingCart();
        app.getCartPage().clickCheckoutButton();
        app.getCheckoutPage().provideUserInformation();
        app.getCheckoutPage().clickContinueButton();
        app.getCheckoutPage().clickFinishButton();
        app.getCheckoutPage().verifyOrderSuccess();
    }

}
