package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.CsvReader;
import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.LocationDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;



import com.infoshare.kodziaki.web.model.Location;
import com.infoshare.kodziaki.web.model.LocationCsvReader;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

@WebServlet("/create-db")
public class CreateDataBaseServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());


    @Inject
    private CsvReader csvReader;

    @Inject
    private LocationCsvReader locationCsvReader;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private LocationDao locationDao;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        try {

            loadAdsFromCsv();
            loadLocationsFromCsv();
            logger.info("Database has been loaded");
            resp.sendRedirect("/main");

        } catch (IOException e) {
            logger.info("Database hasn't been loaded");
            resp.sendRedirect("/main");
        }

    }

    private void loadLocationsFromCsv() throws IOException {
        String locationCsvPath = getServletContext().getResource("/WEB-INF/files/districts.csv").getPath();
        logger.info("locations file path: " + locationCsvPath);
        List<Location> locations = locationCsvReader.readFile(new InputStreamReader(new FileInputStream(locationCsvPath), "UTF-8"));
        for (Location location : locations) {
            locationDao.save(location);
        }
        logger.info("locations have been saved in database");

    }

    private void loadAdsFromCsv() throws IOException {
        String placeCsvPath = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();

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
