import com.infoshare.kodziaki.dao.PlaceDao;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/add-announcement")
public class AddAnnouncementServlet extends HttpServlet {

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String titleParam = req.getParameter("title");

        PlaceType placeTypeParam = parseToPlaceType(req);

        BigDecimal priceParam = parseToBigDecimal(req.getParameter("price"));

        Double areaParam = parseToDouble(req.getParameter("area"));

        Integer roomsParam = parseToInteger(req.getParameter("rooms"));

        Integer floorParam = parseToInteger(req.getParameter("floor"));

        String districtParam = req.getParameter("district");

        String cityParam = req.getParameter("city");

        Boolean hasElevatorParam = parseToBoolean(req.getParameter("isElevator"));

        Boolean smokingAllowedParam = parseToBoolean(req.getParameter("smokingAllowed"));

        Boolean animalAllowedParam = parseToBoolean(req.getParameter("animalsAllowed"));

        Boolean onlyLongTermParam = parseToBoolean(req.getParameter("onlyLongTerm"));

        String descriptionParam = req.getParameter("description");

        String authorParam = req.getParameter("author");

        String phoneNumberParam = req.getParameter("phoneNumber");

        final Place place1 =  new Place();

        place1.setTitle(titleParam);
        place1.setPlaceType(placeTypeParam);
        place1.setPrice(priceParam);
        place1.setArea(areaParam);
        place1.setRooms(roomsParam);
        place1.setFloor(floorParam);
        place1.setDistrict(districtParam);
        place1.setCity(cityParam);
        place1.setHasElevator(hasElevatorParam);
        place1.setSmokingAllowed(smokingAllowedParam);
        place1.setAnimalAllowed(animalAllowedParam);
        place1.setOnlyLongTerm(onlyLongTermParam);
        place1.setDescription(descriptionParam);
        place1.setAuthor(authorParam);
        place1.setPhoneNumber(phoneNumberParam);

        placeDao.save(place1);

        }

    private PlaceType parseToPlaceType(HttpServletRequest req) {
        switch (req.getParameter("placeType")) {
            case "apartment":
                return PlaceType.APARTMENT;
            case "room":
                return PlaceType.ROOM;
            case "bed":
                return PlaceType.BED;
            default:
                return null;
        }
    }

    private BigDecimal parseToBigDecimal(String price) {
        if (price.equals("")) {
            return null;
        }
        return BigDecimal.valueOf(Double.parseDouble(price));
    }

    private Double parseToDouble(String area) {
        if (area.equals("")) {
            return null;
        }
        return Double.parseDouble(area);
    }

    private Integer parseToInteger(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return Integer.parseInt(parameter);
    }

    private Boolean parseToBoolean(String parameter) {
        if (parameter == null) {
            return false;
        }
        return true;
    }

}
