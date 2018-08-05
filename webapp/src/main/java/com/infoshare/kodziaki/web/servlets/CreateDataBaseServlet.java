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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
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
        setImageURLs(ads);
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

    private void setImageURLs(List<Place> ads) {

//        ads.get(0).setImageURL1("/images/22.jpg");
//        ads.get(1).setImageURL1("/images/01.jpg");
//        ads.get(2).setImageURL1("/images/02.jpg");
//        ads.get(3).setImageURL1("/images/03.jpg");
//        ads.get(4).setImageURL1("/images/04.jpg");
//        ads.get(5).setImageURL1("/images/05.jpg");
//        ads.get(6).setImageURL1("/images/06.jpg");
//        ads.get(7).setImageURL1("/images/07.jpg");
//        ads.get(8).setImageURL1("/images/08.jpg");
//        ads.get(9).setImageURL1("/images/09.jpg");
//        ads.get(10).setImageURL1("/images/10.jpg");
//        ads.get(11).setImageURL1("/images/11.jpg");
//        ads.get(12).setImageURL1("/images/12.jpg");
//        ads.get(13).setImageURL1("/images/13.jpg");
//        ads.get(14).setImageURL1("/images/14.jpg");
//        ads.get(15).setImageURL1("/images/15.jpg");
//        ads.get(16).setImageURL1("/images/16.jpg");
//        ads.get(17).setImageURL1("/images/17.jpg");
//        ads.get(18).setImageURL1("/images/18.jpg");
//        ads.get(19).setImageURL1("/images/19.jpg");
//        ads.get(20).setImageURL1("/images/20.jpg");
//        ads.get(21).setImageURL1("/images/21.jpg");
//
//        ads.get(0).setImageURL2("/images/kodziaki.jpg");
//        ads.get(1).setImageURL2("/images/kodziaki.jpg");
//        ads.get(2).setImageURL2("/images/kodziaki.jpg");
//        ads.get(3).setImageURL2("/images/kodziaki.jpg");
//        ads.get(4).setImageURL2("/images/kodziaki.jpg");
//        ads.get(5).setImageURL2("/images/kodziaki.jpg");
//        ads.get(6).setImageURL2("/images/kodziaki.jpg");
//        ads.get(7).setImageURL2("/images/kodziaki.jpg");
//        ads.get(8).setImageURL2("/images/kodziaki.jpg");
//        ads.get(9).setImageURL2("/images/kodziaki.jpg");
//        ads.get(10).setImageURL2("/images/kodziaki.jpg");
//        ads.get(11).setImageURL2("/images/kodziaki.jpg");
//        ads.get(12).setImageURL2("/images/kodziaki.jpg");
//        ads.get(13).setImageURL2("/images/kodziaki.jpg");
//        ads.get(14).setImageURL2("/images/kodziaki.jpg");
//        ads.get(15).setImageURL2("/images/kodziaki.jpg");
//        ads.get(16).setImageURL2("/images/kodziaki.jpg");
//        ads.get(17).setImageURL2("/images/kodziaki.jpg");
//        ads.get(18).setImageURL2("/images/kodziaki.jpg");
//        ads.get(19).setImageURL2("/images/kodziaki.jpg");
//        ads.get(20).setImageURL2("/images/kodziaki.jpg");
//        ads.get(21).setImageURL2("/images/kodziaki.jpg");


    }
}

