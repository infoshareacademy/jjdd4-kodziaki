import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import Freemarker.FreemarkerClient;
import com.isa.freemarker.FreeMarkerClient;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;


@WebServlet("/main")
public class MainPageServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(MainPageServlet.getName());

    @Inject
    private FreemarkerClient templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");

            if (name == null || name.isEmpty()){
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Template template = templateProvider.getTemplate(getServletContext(), "welcome-user.ftlh");
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("name", name);

            try {
                template.process(dataModel, response.getWriter());
            } catch (TemplateException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }






}
}
