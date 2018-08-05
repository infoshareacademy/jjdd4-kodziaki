package com.infoshare.kodziaki.web.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.kodziaki.web.servlets.AboutServlet;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletContext;

@Singleton
public class AdminService {

    Logger logger = Logger.getLogger(getClass().getName());

    private AdminConfig adminConfig;

    @Inject
    private ServletContext servletContext;

    public boolean isAdmin(String email) {
        return adminConfig.getAdmins().contains(email);
    }

    public AdminConfig loadAdminFile(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            logger.info("Admin is available");
            return objectMapper.readerFor(AdminConfig.class).readValue(servletContext.getResource("/WEB-INF/files/admin.json").getPath());
        } catch (IOException e) {
            logger.warning("Error " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
