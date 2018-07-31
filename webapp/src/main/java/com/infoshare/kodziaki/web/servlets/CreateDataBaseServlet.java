package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.CsvReader;
import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.LocationDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.model.Location;
import com.infoshare.kodziaki.web.model.LocationCsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@WebServlet("/create-db")
public class CreateDataBaseServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(CreateDataBaseServlet.class);

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
        logger.info("locations file path: " + locationCsvPath);
        List<Location> locations = locationCsvReader.readFile(new InputStreamReader(new FileInputStream(locationCsvPath), "UTF-8"));
        for (Location location: locations) {
            locationDao.save(location);
        }
        logger.info("locations have been saved in database");

    }

    private void loadAdsFromCsv() throws IOException {
        String placeCsvPath = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();
        logger.info("CSV path 2 " + placeCsvPath);
        logger.info("ads file path: " + placeCsvPath);
        List<Place> ads = csvReader.readFile(new InputStreamReader(new FileInputStream(placeCsvPath), "UTF-8"));
        setFewAdsAsPromoted(ads);
        for (Place place : ads) {
            placeDao.saveAd(place);
        }
        logger.info("ads have been saved in database");
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
