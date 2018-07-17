import com.infoshare.kodziaki.dao.PlaceDao;
import com.infoshare.kodziaki.model.Place;
import com.infoshare.kodziaki.model.Properties;
import com.infoshare.kodziaki.repository.CsvReader;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/create-db")
public class CreateDataBaseServlet extends HttpServlet {

    @Inject
    private CsvReader csvReader;

    @Inject
    private PlaceDao placeDao;

    /* Used to create database from csv file*/
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            String path = getServletContext().getResource("/WEB-INF/files/ads.csv").getPath();
            List<Place> ads = csvReader.readFile(new FileReader(path));
            for (Place place: ads) {
                placeDao.save(place);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
