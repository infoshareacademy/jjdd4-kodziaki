package com.infoshare.kodziaki.web.authorization;

import java.util.List;


public class AdminConfig {

    private List<String> admins;

    public AdminConfig() {
    }

    public AdminConfig(List<String> admins) {
        this.admins = admins;
    }

    public List<String> getAdmins() {
        return admins;
    }
}
