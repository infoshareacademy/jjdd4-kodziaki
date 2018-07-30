package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/detailed")
public class DetailAdServlet extends HttpServlet {

    Logger logger = LogManager.getLogger(DetailAdServlet.class);

    @Inject
    private TemplateProvider templateProvider;
    
    @Inject
    private PlaceDao placeDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "DetailAd.ftlh");
        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        int id = Integer.parseInt(request.getParameter("id"));
        placeDao.updateAdVisits(id);
        dataModel.put("ad", placeDao.findById(id));

        logger.info("Aplikacja zostala uruchomiona");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}