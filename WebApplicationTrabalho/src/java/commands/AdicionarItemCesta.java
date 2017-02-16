package commands;

import dao.CestaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cesta;

/**
 *
 * @author fabiano
 */
public class AdicionarItemCesta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
      
            // pegando os parâmetros do request
            String login = request.getParameter("login");
            String[] item = request.getParameterValues("item");

            for (String ite : item) {
                Cesta Cesta = new Cesta();
                CestaDAO dao = new CestaDAO();

                Cesta.setLogin(login);
                Cesta.setItem(ite);

                dao.salvar(Cesta);
            }

            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-opcionais.jsp");
        try {
            d.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdicionarItemCesta.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}
