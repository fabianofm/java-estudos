/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabia
 */
public class ListarOpcionais implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            HttpSession session = request.getSession();

            Object loginFlag = session.getAttribute("login");
            if (loginFlag != null) {
                
                    RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-opcionais.jsp");
                    d.forward(request, response);
               
            } else {
                // null
                response.sendRedirect("login.jsp");
            }

        } catch (IOException | ServletException e) {
            e.getStackTrace();
        }

    }
}
