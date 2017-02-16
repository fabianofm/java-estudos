package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabia
 */
public class ListarUsuarios implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            HttpSession session = request.getSession();

            Object loginFlag = session.getAttribute("login");
            if (loginFlag != null) {
                String loginFlagStr = String.valueOf(loginFlag);
                if ("admin".equalsIgnoreCase(loginFlagStr)) {
                    RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-usuarios.jsp");
                    d.forward(request, response);
                } else {
                    response.sendRedirect("restrito.jsp");
                }
            } else {
                // null
                response.sendRedirect("login.jsp");
            }

        } catch (ServletException | IOException ex) {
            Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
