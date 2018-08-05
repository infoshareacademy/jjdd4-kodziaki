package com.infoshare.kodziaki.web.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.kodziaki.web.servlets.AboutServlet;

import javax.ejb.Singleton;
import java.io.IOException;
import java.util.logging.Logger;

@Singleton
public class AdminService {

    Logger logger = Logger.getLogger(getClass().getName());

    private final AdminConfig adminConfig;

    public AdminService() {
        adminConfig = loadAdminFile();
    }

    public boolean isAdmin(String email) {
        return adminConfig.getAdmins().contains(email);
    }

    private AdminConfig loadAdminFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            logger.info("Admin is available");
            return objectMapper.readerFor(AdminConfig.class).readValue(AdminService.class.getResourceAsStream("/admins.json"));
        } catch (IOException e) {
            System.out.println("Wystapił blad: " + e.getMessage());
            logger.severe("Error");
            throw new RuntimeException(e);
        }
    }
}
