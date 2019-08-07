package com.goodreads.dataproviders;

import com.opencart.api.strategies.EditAmountProductAddingStrategy;
import com.opencart.api.strategies.MultipleRequestsProductAddingStrategy;
import com.opencart.api.strategies.OneRequestProductAddingStrategy;
import org.testng.annotations.DataProvider;

public class OpenCartDataProvider {
    @DataProvider
    public static Object[][] provideItemData() {
        return new Object[][]{
                {"41", "1", new OneRequestProductAddingStrategy()},
                {"41", "2", new EditAmountProductAddingStrategy()},
                {"41", "2", new MultipleRequestsProductAddingStrategy()},
                {"41", "2", new OneRequestProductAddingStrategy()},
        };
    }
}
