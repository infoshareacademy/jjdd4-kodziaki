package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;


@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(MainPageServlet.class);

    @Inject
    private PlaceDao placeDao;

    @Inject
    private TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "MainPage.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        List<Place> adsList = placeDao.getAllAds();
        List<Place> four = adsList.stream().limit(4).collect(Collectors.toList());
        dataModel.put("ads", four);

        response.setContentType("text/html;charset=UTF-8");

        try {
            template.process(dataModel, response.getWriter());
        } catch (TemplateException e) {
            LOG.error(e.getMessage());
        }
    }
}