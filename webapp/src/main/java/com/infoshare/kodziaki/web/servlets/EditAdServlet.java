package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.PlaceDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/edit")
public class EditAdServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            logger.info("Value cannot be parsed");
        }

        Place place = null;
        if (id != null) {
            try {
                place = placeDao.findById(id);
            } catch (Exception e) {
                logger.info("No ad has been found");
            }
        }

        String action = req.getParameter("action");
        if (place != null) {
            switch (action) {
                case "promote":
                    placeDao.updateAdPromotion(id);
                    logger.info("Ad with id " + id + " has been set as promoted");
                    break;
//                case "edit":
//
//                    break;
                case "delete":
                    placeDao.delete(id);
                    logger.info("Ad with id " + id + "has been removed from database");
                    break;
                default:
                    logger.warning("The operation is unavailable");
            }
        }


    }
}
