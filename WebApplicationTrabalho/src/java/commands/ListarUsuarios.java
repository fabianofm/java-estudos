/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
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

            HttpSession session = request.getSession(false);

            if (session != null) {
                // session.invalidate();
                String s = session.getAttribute("login").toString();
                if (s.equals("admin")) {
                    RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-usuarios.jsp");
                    d.forward(request, response);
                }
            } else {
                RequestDispatcher d = request.getRequestDispatcher("login.jsp");
                d.forward(request, response);
                 return;
            }

        } catch (IOException e) {
            e.toString();
        } catch (ServletException ex) {
            Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
