import com.infoshare.kodziaki.dao.PlaceDao;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.PlaceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/add-announcement")
public class AddAnnouncementServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(AddAnnouncementServlet.class);

    @Inject
    private PlaceDao placeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        final Place place =  new Place();

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

        placeDao.save(place);
        LOG.info("Saved new announcement ", place);

        }
}
