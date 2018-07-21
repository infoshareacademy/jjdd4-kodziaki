package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.web.dao.PlaceDao;
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
import java.util.List;
import java.util.Map;
import java.util.Random;

@WebServlet("/random")
public class RandomAdServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(DetailAdServlet.class);

    @Inject
    private TemplateProvider templateProvider;
    
    @Inject
    private PlaceDao placeDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "RandomAd.ftlh");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> detailAdParams = new HashMap<>();

        try {
            template.process(detailAdParams.get(detailAdParams), response.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
     
        List<Place> adsList = placeDao.getAllAds();
        Random r = new Random();
        Place randomPlace = adsList.get((int)Math.random() * adsList.length);    
        
    }    

}