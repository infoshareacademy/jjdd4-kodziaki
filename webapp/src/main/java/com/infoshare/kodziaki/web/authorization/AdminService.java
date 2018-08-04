package com.infoshare.kodziaki.web.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.kodziaki.web.servlets.AboutServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.io.IOException;

@Singleton
public class AdminService {

    private Logger LOG = LoggerFactory.getLogger(AdminService.class);

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
            return objectMapper.readerFor(AdminConfig.class).readValue(AdminService.class.getResourceAsStream("/admins.json"));
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
