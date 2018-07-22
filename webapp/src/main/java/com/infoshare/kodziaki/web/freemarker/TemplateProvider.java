package com.infoshare.kodziaki.web.freemarker;

import com.infoshare.kodziaki.web.freemarker.ConfigProvider;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.IOException;

@ApplicationScoped
public class TemplateProvider {


    private final String TEMPLATE_DIRECTORY_PATH = "WEB-INF/fm-templates";

    private Configuration configuration;

    @Inject
    private ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName) throws IOException {

        configuration = configProvider.getConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);

    }
}
