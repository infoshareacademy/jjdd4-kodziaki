package com.infoshare.kodziaki.web.authorization;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Stateless
public class AdminConfig {

    private List<String> adminEmails = Collections.emptyList();

    public AdminConfig() {

    }

    @PostConstruct
    public void initAdminsEmails() {
        adminEmails = Arrays.asList("kodziakiteam@gmail.com");
    }

    public AdminConfig(List<String> admins) {
        this.adminEmails = admins;
    }

    public List<String> getAdmins() {
        return adminEmails;
    }
}
