/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

            HttpSession session = request.getSession(false);
            String s = session.getAttribute("login").toString();

            if (s.equals("admin")) {

                RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-usuarios.jsp");
                d.forward(request, response);

            } else {
                
                response.sendRedirect("login.jsp");
            }

        } catch (IOException e) {
            e.toString();
        } catch (ServletException ex) {
            Logger.getLogger(ListarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
