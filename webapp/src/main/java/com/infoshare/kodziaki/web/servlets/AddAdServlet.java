package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.PlaceType;
import com.infoshare.kodziaki.web.dao.ImageUploadDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.dao.UserImageNotFound;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/add")
@MultipartConfig
public class AddAdServlet extends HttpServlet {

    Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    private PlaceDao placeDao;

    @Inject
    private ImageUploadDao imageUploadDao;
    
    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "AddAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        Template template = templateProvider.getTemplate(getServletContext(), "DetailAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        req.setCharacterEncoding("UTF-8");
        
        try {
            Place place = savePlace(req);
            dataModel.put("ad", place);
            dataModel.put("message", "Ogłoszenie zostało dodane.");
        } catch (Exception e) {
            resp.getWriter().println("Wystapił blad: " + e.getMessage());
        }

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
        }
    }

    private Place savePlace(HttpServletRequest req) throws IOException, ServletException {
        String titleParam = req.getParameter("title");
        PlaceType placeTypeParam = validatePlaceType(req.getParameter("placeType").toUpperCase());
        BigDecimal priceParam = validateBigDecimal(req.getParameter("price"));
        Double areaParam = validateDouble(req.getParameter("area"));
        Integer roomsParam = validateInteger(req.getParameter("rooms"));
        Integer floorParam = validateInteger(req.getParameter("floor"));
        String districtParam = req.getParameter("district");
        String cityParam = req.getParameter("city");
        Boolean hasElevatorParam = validateBoolean(req.getParameter("hasElevator"));
        Boolean smokingAllowedParam = validateBoolean(req.getParameter("smokingAllowed"));
        Boolean animalAllowedParam = validateBoolean(req.getParameter("animalAllowed"));
        Boolean onlyLongTermParam = validateBoolean(req.getParameter("onlyLongTerm"));
        String descriptionParam = req.getParameter("description");
        String authorParam = req.getParameter("author");
        String phoneNumberParam = req.getParameter("phoneNumber");

        final Place place = new Place();

        place.setId(placeDao.getLastId().intValue() + 1);
        place.setTitle(titleParam);
        place.setPlaceType(placeTypeParam);
        place.setPrice(priceParam);
        place.setArea(areaParam);
        place.setRooms(roomsParam);
        place.setFloor(floorParam);
        place.setDistrict(districtParam);
        place.setCity(cityParam);
        place.setHasElevator(hasElevatorParam);
        place.setSmokingAllowed(smokingAllowedParam);
        place.setAnimalAllowed(animalAllowedParam);
        place.setOnlyLongTerm(onlyLongTermParam);
        place.setDescription(descriptionParam);
        place.setAuthor(authorParam);
        place.setPhoneNumber(phoneNumberParam);

        Part filePart1 = req.getPart("image1");

        File file1 = null;
        try {
            file1 = imageUploadDao.uploadImageFile(filePart1);
            place.setImageURL1("/images/" + file1.getName());
        } catch (Exception e1) {
            logger.log(Level.SEVERE, "Image not found");
            throw new RuntimeException("Image not found1");
        }

        Part filePart2 = req.getPart("image2");

        File file2 = null;
        try {
            file2 = imageUploadDao.uploadImageFile(filePart2);
            place.setImageURL2("/images/" + file2.getName());
        } catch (Exception e2) {
            logger.log(Level.SEVERE, "Image not found");
            throw new RuntimeException("Image not found2");
        }

        Part filePart3 = req.getPart("image3");

        File file3 = null;
        try {
            file3 = imageUploadDao.uploadImageFile(filePart3);
            place.setImageURL3("/images/" + file3.getName());
        } catch (Exception e3) {
            logger.log(Level.SEVERE, "Image not found");
            throw new RuntimeException("Image not found3");
        }

        Part filePart4 = req.getPart("image4");

        File file4 = null;
        try {
            file4 = imageUploadDao.uploadImageFile(filePart4);
            place.setImageURL4("/images/" + file4.getName());
        } catch (Exception e4) {
            logger.log(Level.SEVERE, "Image not found");
            throw new RuntimeException("Image not found4");
        }

        Part filePart5 = req.getPart("image5");

        File file5 = null;
        try {
            file5 = imageUploadDao.uploadImageFile(filePart5);
            place.setImageURL5("/images/" + file5.getName());
        } catch (Exception e5) {
            logger.log(Level.SEVERE, "Image not found");
            throw new RuntimeException("Image not found5");
        }

        placeDao.saveAd(place);
        logger.log(Level.INFO, "New place has been added " + place);
        return place;
    }


    private Integer validateInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
        }
    }

    private Boolean validateBoolean(String value) {
        try {
            return Boolean.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
        }
        throw new RuntimeException("Value '" + value + "' cannot be parsed into Boolean");
    }

    private Double validateDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Double");
        }
    }

    private PlaceType validatePlaceType(String value) {
        try {
            return PlaceType.valueOf(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into PlaceType");
        }
    }

    private BigDecimal validateBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invalid value: " + value);
            throw new RuntimeException("Value '" + value + "' cannot be parsed into BigDecimal");
        }
    }

}
