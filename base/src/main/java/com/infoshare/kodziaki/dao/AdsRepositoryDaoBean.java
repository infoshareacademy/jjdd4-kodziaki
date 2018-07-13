package com.infoshare.kodziaki.dao;

import com.infoshare.kodziaki.repository.CsvReader;
import com.infoshare.kodziaki.domain.Place;
import com.infoshare.kodziaki.Properties;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Stateless
public class AdsRepositoryDaoBean {
    public List<Place> getAdsList() throws IOException {
        return CsvReader.readFile(new FileReader(Properties.getAdsFilePath()));
    }
}
