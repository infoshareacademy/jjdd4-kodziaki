package com.infoshare.kodziaki.web.authorization;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;
import javax.ejb.Singleton;
import java.io.IOException;

@Singleton
public class AdminService {
    Logger logger = Logger.getLogger(getClass().getName());

    private final AdminConfig adminConfig;

    public AdminService() {
        adminConfig = loadAdminFile();
    }

    public AdminConfig getAdminConfiguration() {
        return adminConfig;
    }

    public boolean isAdmin(String email) {
        return adminConfig.getAdmins().contains(email);
    }

    private AdminConfig loadAdminFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readerFor(AdminConfig.class).readValue(AdminService.class.getResourceAsStream("/admins.json"));
        } catch (IOException e) {
            System.out.println("Wystapił blad: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
