package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/filtered")
public class FilteredAdsServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(FilteredAdsServlet.class);

    @Inject
    private TemplateProvider templateProvider;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // tutaj metody do szukania ogłoszeń? Dao? FindAll itp.?
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "FilteredAds.ftlh");
        Map<String, Object> filteredAds = new HashMap<>();

        response.setContentType("text/html;charset=UTF-8");

        try {
            template.process(filteredAds, response.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }
    }
}
