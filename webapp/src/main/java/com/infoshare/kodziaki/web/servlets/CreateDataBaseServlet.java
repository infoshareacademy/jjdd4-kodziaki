package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.CsvReader;
import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/create-db")
public class CreateDataBaseServlet extends HttpServlet {

    Logger logger = LogManager.getLogger(CreateDataBaseServlet.class);
    @Inject
    private CsvReader csvReader;

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        // filling database with ads from csv
        try {
            String path = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();
            List<Place> ads = csvReader.readFile(new FileReader(path));
            ads.get(3).setPromoted(true);
            ads.get(7).setPromoted(true);
            ads.get(11).setPromoted(true);
            ads.get(18).setPromoted(true);
            for (Place place: ads) {
                placeDao.saveAd(place);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        logger.info("Aplikacja zostala uruchomiona");
    }
}
