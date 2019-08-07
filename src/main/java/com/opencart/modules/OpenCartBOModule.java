package com.opencart.modules;

import com.google.inject.AbstractModule;
import com.opencart.api.OpenCartBO;
import com.opencart.api.OpenCartTestBO;

public class OpenCartBOModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(OpenCartBO.class).to(OpenCartTestBO.class);
    }
}
