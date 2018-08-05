package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/edit")
public class EditAdServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "PanelOperationConfirm.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("isLoggedIn", req.getSession().getAttribute("userLogged"));
        dataModel.put("isAdminLoggedIn", req.getSession().getAttribute("adminLogged"));

        Integer id = getId(req.getParameter("id"));
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
            editAd(action, id, dataModel);
        }

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.warning("Template not found ");
        }

    }

    private void editAd(String action, Integer id, Map<String, Object> dataModel) {
        switch (action) {
            case "promote":
                placeDao.updateAdPromotion(id);
                logger.info("Ad with id " + id + " has been set as promoted");
                dataModel.put("message", "Ogłoszenie zostało oznaczone jako promowane");
                break;
            case "unpromote":
                placeDao.updateAdPromotion(id);
                logger.info("Ad with id " + id + " has been set as promoted");
                dataModel.put("message", "Promowanie ogłoszenia zostało zakończone");
                break;
            case "delete":
                placeDao.delete(id);
                logger.info("Ad with id " + id + "has been removed from database");
                dataModel.put("message", "Ogłoszenie zostało usunięte");
                break;
            default:
                logger.warning("The operation is unavailable");
                dataModel.put("message", "Operacja niedozwolona");
        }
    }

    private Integer getId(String id) {
        try {
            return Integer.parseInt(id);
        } catch (Exception e) {
           logger.info("Value cannot be parsed");
        }
        return null;
    }
}
