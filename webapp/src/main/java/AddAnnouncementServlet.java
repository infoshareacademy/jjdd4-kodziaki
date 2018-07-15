import com.infoshare.kodziaki.dao.AddAnnouncementDao;
import com.infoshare.kodziaki.model.PlaceType;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/add-announcement")
public class AddAnnouncementServlet extends HttpServlet {

    @Inject
    private AddAnnouncementDao addAnnouncementDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String title = req.getParameter("title");

        PlaceType placeType = parseToPlaceType(req);

        BigDecimal price = parseToBigDecimal(req.getParameter("price"));

        Double area = parseToDouble(req.getParameter("area"));

        Integer rooms = parseToInteger(req.getParameter("rooms"));

        Integer floor = parseToInteger(req.getParameter("floor"));

        String district = req.getParameter("district");

        String city = req.getParameter("city");

        Boolean isElevator = parseToBoolean(req.getParameter("isElevator"));

        Boolean smokingAllowed = parseToBoolean(req.getParameter("smokingAllowed"));

        Boolean animalsAllowed = parseToBoolean(req.getParameter("animalsAllowed"));

        Boolean onlyLongTerm = parseToBoolean(req.getParameter("onlyLongTerm"));

        String descriprion = req.getParameter("description");

        String author = req.getParameter("author");

        String contact = req.getParameter("contact");

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
    
    AddAnnouncementDao a1 = new AddAnnouncementDao();

}
