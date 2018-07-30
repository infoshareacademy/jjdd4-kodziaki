package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.CsvReader;
import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.LocationDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.model.Location;
import com.infoshare.kodziaki.web.model.LocationCsvReader;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@WebServlet("/create-db")
public class CreateDataBaseServlet extends HttpServlet {

    @Inject
    private CsvReader csvReader;

    @Inject
    private LocationCsvReader locationCsvReader;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private LocationDao locationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {

            loadAdsFromCsv();
            loadLocationsFromCsv();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLocationsFromCsv() throws IOException {
        String locationCsvPath = getServletContext().getResource("/WEB-INF/files/districts.csv").getPath();
        List<Location> locations = locationCsvReader.readFile(new FileReader(locationCsvPath));
        for (Location location: locations) {
            locationDao.save(location);
        }
    }

    private void loadAdsFromCsv() throws IOException {
        String placeCsvPath = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();
        List<Place> ads = csvReader.readFile(new InputStreamReader(new FileInputStream(placeCsvPath), "UTF-8"));
        setFewAdsAsPromoted(ads);
        for (Place place : ads) {
            placeDao.saveAd(place);
        }
    }

    private void setFewAdsAsPromoted(List<Place> ads) {
        ads.get(3).setPromoted(true);
        ads.get(7).setPromoted(true);
        ads.get(11).setPromoted(true);
        ads.get(18).setPromoted(true);
        ads.get(20).setPromoted(true);
        ads.get(1).setPromoted(true);
    }
}
