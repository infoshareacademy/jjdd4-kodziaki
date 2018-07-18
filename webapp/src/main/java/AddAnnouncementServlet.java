import com.infoshare.kodziaki.dao.PlaceDao;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/add-announcement")
public class AddAnnouncementServlet extends HttpServlet {

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String titleParam = req.getParameter("title");

        PlaceType placeTypeParam = PlaceType.valueOf(req.getParameter("placeType").toUpperCase());

        BigDecimal priceParam = new BigDecimal(req.getParameter("price"));

        Double areaParam = Double.parseDouble(req.getParameter("area"));

        Integer roomsParam = Integer.valueOf(req.getParameter("rooms"));

        Integer floorParam = Integer.valueOf(req.getParameter("floor"));

        String districtParam = req.getParameter("district");

        String cityParam = req.getParameter("city");

        Boolean hasElevatorParam = Boolean.valueOf(req.getParameter("hasElevator"));

        Boolean smokingAllowedParam = Boolean.valueOf(req.getParameter("smokingAllowed"));

        Boolean animalAllowedParam = Boolean.valueOf(req.getParameter("animalAllowed"));

        Boolean onlyLongTermParam = Boolean.valueOf(req.getParameter("onlyLongTerm"));

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
}
