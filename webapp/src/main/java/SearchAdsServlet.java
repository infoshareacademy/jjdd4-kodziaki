
import com.infoshare.kodziaki.dao.PlaceDao;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;
import com.infoshare.kodziaki.model.UserPreferences;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/search-ads")
public class SearchAdsServlet extends HttpServlet {

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("siema doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();
        writer.print("siema doPost");

        UserPreferences userPreferences = new UserPreferences();

        userPreferences.setMinPrice();

        userPreferences.setMinArea(parseToDouble(req.getParameter("minArea")));
        userPreferences.setMaxArea(parseToDouble(req.getParameter("maxArea")));

        userPreferences.setMinFloor(parseToInteger(req.getParameter("minFloor")));
        userPreferences.setMaxFloor(parseToInteger(req.getParameter("maxFloor")));

        userPreferences.setMinRooms(parseToInteger(req.getParameter("minRooms")));
        userPreferences.setMaxRooms(parseToInteger(req.getParameter("maxRooms")));

        userPreferences.setAnimalAllowed(parseToBoolean(req.getParameter("animalsAllowed")));
        userPreferences.setSmokingAllowed(parseToBoolean(req.getParameter("smokingAllowed")));
        userPreferences.setHasElevator(parseToBoolean(req.getParameter("isElevator")));
        userPreferences.setOnlyLongTerm(parseToBoolean(req.getParameter("onlyLongTerm")));

        userPreferences.setMinPrice(parseToBigDecimal(req.getParameter("minPrice")));
        userPreferences.setMaxPrice(parseToBigDecimal(req.getParameter("maxPrice")));

        writer.println(userPreferences.getMinPrice());
        writer.println(userPreferences.getMaxPrice());

//
//        List<Place> places = placeDao.find(userPreferences);
//        places.stream().map(Place::getId).peek(writer::println);

//        PlaceType placeType = parseToPlaceType(req);

//        String city = req.getParameter("city");
//        String district = req.getParameter("district");
//
//        BigDecimal minPrice = parseToBigDecimal(req.getParameter("minPrice"));
//        BigDecimal maxPrice = parseToBigDecimal(req.getParameter("maxPrice"));

    }

    private Boolean parseToBoolean(String parameter) {
        if (parameter == null) {
            return null;
        }
        switch (parameter) {
            case "true":
                return true;
            case "false":
                return false;
        }
        return null;
    }

    private Integer parseToInteger(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return Integer.parseInt(parameter);
    }

    private Double parseToDouble(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return Double.parseDouble(parameter);
    }

    private BigDecimal parseToBigDecimal(String parameter) {
        if (parameter.equals("")) {
            return null;
        }
        return BigDecimal.valueOf(Double.parseDouble(parameter));
    }
//
//    private PlaceType parseToPlaceType(HttpServletRequest req) {
//        switch (req.getParameter("placeType")) {
//            case "apartment":
//                return PlaceType.APARTMENT;
//            case "room":
//                return PlaceType.ROOM;
//            case "bed":
//                return PlaceType.BED;
//            default:
//                return null;
//        }
//    }

}
