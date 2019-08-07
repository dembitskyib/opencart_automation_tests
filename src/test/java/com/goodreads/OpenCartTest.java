package com.goodreads;

import com.goodreads.dataproviders.OpenCartDataProvider;
import com.goodreads.utils.listeners.OpenCartTestListener;
import com.google.inject.Inject;
import com.jayway.restassured.response.Response;
import com.opencart.allure.AllureEnvironmentController;
import com.opencart.api.OpenCartBO;
import com.opencart.api.strategies.ProductAddingStrategy;
import com.opencart.modules.OpenCartBOModule;
import com.opencart.verification.VerificationDirector;
import com.opencart.verification.commands.ContentVerificationCommand;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Guice(modules = {OpenCartBOModule.class})
@Listeners(OpenCartTestListener.class)
@Feature("Opencart endpoints")
@Story("Opencart endpoints should work correctly")
public class OpenCartTest {

    @Inject
    private OpenCartBO openCartBO;

    @Test(description = "Verify adding product to cart (product id: %s; quantity: %s)",
            dataProvider = "provideItemData",
            dataProviderClass = OpenCartDataProvider.class)
    public void verifyProductToCartAdding(String productId, String quantity, ProductAddingStrategy productAddingStrategy) {
        ContentVerificationCommand contentVerificationCommand = new ContentVerificationCommand();
        contentVerificationCommand.addContentVerification("products.product_id[0]", Matchers.equalTo(productId));
        contentVerificationCommand.addContentVerification("products.quantity[0]", Matchers.equalTo(quantity));
        Response response = openCartBO.addItem(productAddingStrategy, productId, quantity);
        new VerificationDirector().createVerification(contentVerificationCommand, response).verifyAll();
    }

    @Test(description = "Verify cart deletion")
    public void verifyCartDeletion() {
        ContentVerificationCommand contentVerificationCommand = new ContentVerificationCommand();
        contentVerificationCommand.addContentVerification("products", Matchers.empty());
        Response response = openCartBO.removeCart();
        new VerificationDirector().createVerification(contentVerificationCommand, response).verifyAll();
    }

    @AfterClass
    public void createPropertyFile() {
        new AllureEnvironmentController().createPropertyFile();
    }

}
