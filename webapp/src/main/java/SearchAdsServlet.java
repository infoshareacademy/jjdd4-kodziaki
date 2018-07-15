
import com.infoshare.kodziaki.dao.AdsRepositoryDaoBean;
import com.infoshare.kodziaki.model.PlaceType;
import com.infoshare.kodziaki.model.UserPreferences;
import com.infoshare.kodziaki.repository.FilterAdsByPreferencesBean;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/search-ads")
public class SearchAdsServlet extends HttpServlet {

    @Inject
    private AdsRepositoryDaoBean adsRepositoryDaoBean;

    @Inject
    private FilterAdsByPreferencesBean filterAdsByPreferencesBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PlaceType placeType = parseToPlaceType(req);

        String city = req.getParameter("city");
        String district = req.getParameter("district");

        BigDecimal minPrice = parseToBigDecimal(req.getParameter("minPrice"));
        BigDecimal maxPrice = parseToBigDecimal(req.getParameter("maxPrice"));

        Double minArea = parseToDouble(req.getParameter("minArea"));
        Double maxArea = parseToDouble(req.getParameter("maxArea"));

        Integer minFloor = parseToInteger(req.getParameter("minFloor"));
        Integer maxFloor = parseToInteger(req.getParameter("maxFloor"));

        Integer minRooms = parseToInteger(req.getParameter("minRooms"));
        Integer maxRooms = parseToInteger(req.getParameter("maxRooms"));

        Boolean animalsAllowed = parseToBoolean(req.getParameter("animalsAllowed"));
        Boolean smokingAllowed = parseToBoolean(req.getParameter("smokingAllowed"));
        Boolean isElevator = parseToBoolean(req.getParameter("isElevator"));
        Boolean onlyLongTerm = parseToBoolean(req.getParameter("onlyLongTerm"));

        UserPreferences userPreferences = new UserPreferences(
                placeType,
                city,
                district,
                minPrice,
                maxPrice,
                minArea,
                maxArea,
                minFloor,
                maxFloor,
                minRooms,
                maxRooms,
                animalsAllowed,
                smokingAllowed,
                isElevator,
                onlyLongTerm);

        PrintWriter writer = resp.getWriter();
        writer.println(userPreferences.toString());

        filterAdsByPreferencesBean.filterAdsByPreferences(adsRepositoryDaoBean.getAdsList(), userPreferences);
    }

    private Boolean parseToBoolean(String parameter) {
        if (parameter == null) {
            return false;
        }
        return true;
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

}
