package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UsuarioDAO;


/**
 *
 * @author
 */
public class LoginServlet implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            UsuarioDAO dao =  UsuarioDAO.getInstance();

            if (dao.login(login, senha) != null) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("login", login);

                response.sendRedirect("index.jsp");

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
