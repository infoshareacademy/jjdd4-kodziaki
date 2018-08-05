package com.infoshare.kodziaki.web.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class ConfigProvider {

    private Configuration configuration;

    public Configuration getConfiguration() throws IOException {

        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
        }

        return configuration;
    }
}