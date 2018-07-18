package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.model.City;
import com.infoshare.kodziaki.model.CsvReader;
import com.infoshare.kodziaki.model.District;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.web.dao.CityDao;
import com.infoshare.kodziaki.web.dao.DistrictDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;

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

    @Inject
    private CsvReader csvReader;

    @Inject
    private PlaceDao placeDao;

    @Inject
    private CityDao cityDao;

    @Inject
    private DistrictDao districtDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // filling database with ads from csv
        try {
            String path = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();
            List<Place> ads = csvReader.readFile(new FileReader(path));
            for (Place place: ads) {
                placeDao.saveAd(place);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // filling database with cities
//        City city1 = new City("Gdańsk");
//        cityDao.save(city1);
//        City city2 = new City("Gdynia");
//        cityDao.save(city2);
//        City city3 = new City("Sopot");
//        cityDao.save(city3);
//
//        resp.getWriter().println(cityDao.getAll().toString());
//
//        //filling database with districts
//        District dist1 = new District("Wrzeszcz");
//        districtDao.save(dist1);
//        District dist2 = new District("Zaspa");
//        districtDao.save(dist2);
//        District dist3 = new District("Chylonia");
//        districtDao.save(dist3);
//        District dist4 = new District("Główna");
//        districtDao.save(dist4);
//        District dist5 = new District("Wyścigi");
//        districtDao.save(dist5);
//
//        resp.getWriter().println(districtDao.getAll().toString());

    }
}
