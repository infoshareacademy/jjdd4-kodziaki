package com.infoshare.kodziaki.web.servlets;

import com.infoshare.kodziaki.Place;
import com.infoshare.kodziaki.PlaceType;
import com.infoshare.kodziaki.web.dao.ImageUploadDao;
import com.infoshare.kodziaki.web.dao.LocationDao;
import com.infoshare.kodziaki.web.dao.PlaceDao;
import com.infoshare.kodziaki.web.freemarker.TemplateProvider;
import com.infoshare.kodziaki.web.model.Location;
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
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.owasp.html.HtmlPolicyBuilder;

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

    @Inject
    private LocationDao locationDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "AddAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("isLoggedIn", req.getSession().getAttribute("userLogged"));
        dataModel.put("locations", sortDistrictsByCities());

        try {
            template.process(dataModel, resp.getWriter());
        } catch (TemplateException e) {
            logger.log(Level.INFO, "Template not found", e.getMessage());
           // resp.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "DetailAd.ftlh");
        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("isLoggedIn", req.getSession().getAttribute("userLogged"));

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
           // resp.sendRedirect("/error");
        }

    }

        private Map<String, List<Location>> sortDistrictsByCities () {
            return locationDao
                    .findAll()
                    .stream()
                    .collect(Collectors.groupingBy(Location::getCity));
        }

        private Place savePlace (HttpServletRequest req) {
            String titleParam = req.getParameter("title");
            PlaceType placeTypeParam = validatePlaceType(req.getParameter("placeType").toUpperCase());
            BigDecimal priceParam = validateBigDecimal(req.getParameter("price"));
            Double areaParam = validateDouble(req.getParameter("area"));
            Integer roomsParam = validateInteger(req.getParameter("rooms"));
            Integer floorParam = validateInteger(req.getParameter("floor"));
            String cityParam = validateCity(req.getParameter("localization"));
            String districtParam = validateDistrict(req.getParameter("localization"));
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

            File file = null;

            try {
                List<Part> fileParts = req.getParts().stream().filter(part -> "image".equals(part.getName())).collect(Collectors.toList());
                for (Part filePart : fileParts)

                    if (fileParts.size() == 0) {
                        place.setImageURL1("/images/kodziaki.jpg");
                        place.setImageURL2("/images/kodziaki.jpg");
                        place.setImageURL3("/images/kodziaki.jpg");
                        place.setImageURL4("/images/kodziaki.jpg");
                        place.setImageURL5("/images/kodziaki.jpg");
                    }


                if (fileParts.size() == 1) {
                    place.setImageURL1("/images/" + imageUploadDao.uploadImageFile(fileParts.get(0)).getName());
                    place.setImageURL2("/images/kodziaki.jpg");
                    place.setImageURL3("/images/kodziaki.jpg");
                    place.setImageURL4("/images/kodziaki.jpg");
                    place.setImageURL5("/images/kodziaki.jpg");
                }

                if (fileParts.size() == 2) {
                    place.setImageURL1("/images/" + imageUploadDao.uploadImageFile(fileParts.get(0)).getName());
                    place.setImageURL2("/images/" + imageUploadDao.uploadImageFile(fileParts.get(1)).getName());
                    place.setImageURL3("/images/kodziaki.jpg");
                    place.setImageURL4("/images/kodziaki.jpg");
                    place.setImageURL5("/images/kodziaki.jpg");
                }

                if (fileParts.size() == 3) {
                    place.setImageURL1("/images/" + imageUploadDao.uploadImageFile(fileParts.get(0)).getName());
                    place.setImageURL2("/images/" + imageUploadDao.uploadImageFile(fileParts.get(1)).getName());
                    place.setImageURL3("/images/" + imageUploadDao.uploadImageFile(fileParts.get(2)).getName());
                    place.setImageURL4("/images/kodziaki.jpg");
                    place.setImageURL5("/images/kodziaki.jpg");
                }

                if (fileParts.size() == 4) {
                    place.setImageURL1("/images/" + imageUploadDao.uploadImageFile(fileParts.get(0)).getName());
                    place.setImageURL2("/images/" + imageUploadDao.uploadImageFile(fileParts.get(1)).getName());
                    place.setImageURL3("/images/" + imageUploadDao.uploadImageFile(fileParts.get(2)).getName());
                    place.setImageURL4("/images/" + imageUploadDao.uploadImageFile(fileParts.get(3)).getName());
                    place.setImageURL5("/images/kodziaki.jpg");
                }

                if (fileParts.size() >= 5) {
                    place.setImageURL1("/images/" + imageUploadDao.uploadImageFile(fileParts.get(0)).getName());
                    place.setImageURL2("/images/" + imageUploadDao.uploadImageFile(fileParts.get(1)).getName());
                    place.setImageURL3("/images/" + imageUploadDao.uploadImageFile(fileParts.get(2)).getName());
                    place.setImageURL4("/images/" + imageUploadDao.uploadImageFile(fileParts.get(3)).getName());
                    place.setImageURL5("/images/" + imageUploadDao.uploadImageFile(fileParts.get(4)).getName());
                }


            } catch (Exception e1) {
                logger.log(Level.SEVERE, "Image not found");
                throw new RuntimeException("Image not found", e1);
            }

            placeDao.saveAd(place);
            logger.log(Level.INFO, "New place has been added " + place);
            return place;
        }


        private String validateCity (String localization){
            String[] localizationParams = localization.split(",");
            return localizationParams[0];
        }

        private String validateDistrict (String localization){
            String[] localizationParams = localization.split(",");
            return localizationParams[1];
        }

        private Integer validateInteger (String value){
            try {
                return Integer.valueOf(value);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid value: " + value);
                throw new RuntimeException("Value '" + value + "' cannot be parsed into Integer");
            }
        }

        private Boolean validateBoolean (String value){
            try {
                return Boolean.valueOf(value);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid value: " + value);
            }
            throw new RuntimeException("Value '" + value + "' cannot be parsed into Boolean");
        }

        private Double validateDouble (String value){
            try {
                return Double.valueOf(value);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid value: " + value);
                throw new RuntimeException("Value '" + value + "' cannot be parsed into Double");
            }
        }

        private PlaceType validatePlaceType (String value){
            try {
                return PlaceType.valueOf(value);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid value: " + value);
                throw new RuntimeException("Value '" + value + "' cannot be parsed into PlaceType");
            }
        }

        private BigDecimal validateBigDecimal (String value){
            try {
                return new BigDecimal(value);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Invalid value: " + value);
                throw new RuntimeException("Value '" + value + "' cannot be parsed into BigDecimal");
            }
        }

    }

