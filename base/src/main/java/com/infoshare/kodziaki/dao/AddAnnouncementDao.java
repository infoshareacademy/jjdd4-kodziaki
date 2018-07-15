package com.infoshare.kodziaki.dao;

import com.infoshare.kodziaki.model.Properties;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Stateless
public class AddAnnouncementDao {

    public Long getId() {

        Long id = null;

        try {
            FileReader file = new FileReader(Properties.getAdsFilePath());
            BufferedReader countLines = new BufferedReader(file);
            id = countLines.lines().count();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return id;
    }

    public void save(List<Object> list) {

        try {
            FileWriter file1 = new FileWriter(Properties.getAdsFilePath(), true);
            BufferedWriter add = new BufferedWriter(file1);
            add.newLine();
            add.write(list.stream().map(Object::toString).collect(joining(";")));
            add.close();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    };


}
