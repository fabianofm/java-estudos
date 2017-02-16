package commands;

import dao.CestaDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cesta;

/**
 *
 * @author fabiano
 */
public class RemoverItemCesta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Integer id = Integer.parseInt(request.getParameter("id"));
        CestaDAO dao = new CestaDAO();
        List<Cesta> ofItem = dao.findLogin(id);
        try {
            for (Object value : ofItem) {
                String loginOfItem = String.valueOf(value);

                HttpSession session = request.getSession();

                Object loginFlag = session.getAttribute("login");
                if (loginFlag != null) {
                    String loginFlagStr = String.valueOf(loginFlag);
                    if (loginOfItem.equalsIgnoreCase(loginFlagStr)) {

                        dao.excluir(id);

                        RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-opcionais.jsp");
                        d.forward(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                } else {

                    response.sendRedirect("login.jsp");

                }
            }

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");

            d.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RemoverItemCesta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
