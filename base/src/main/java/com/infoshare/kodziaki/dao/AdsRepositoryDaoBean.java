package com.infoshare.kodziaki.dao;

import com.infoshare.kodziaki.repository.CsvReader;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.Properties;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Stateless
public class AdsRepositoryDaoBean {
    public List<Place> getAdsList() throws IOException {
        CsvReader csvReader = new CsvReader();
        return csvReader.readFile(new FileReader(Properties.getAdsFilePath()));
    }
}
