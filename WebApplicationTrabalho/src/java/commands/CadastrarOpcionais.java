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
 * @author fab
 */
public class CadastrarOpcionais implements Command {
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {

            
            HttpSession session = request.getSession();

            Object loginFlag = session.getAttribute("login");
            if (loginFlag != null) {
                String loginFlagStr = String.valueOf(loginFlag);
                if ("admin".equalsIgnoreCase(loginFlagStr)) {
                    RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/cadastrar-opcionais.jsp");
                    d.forward(request, response);
                } else {
                    // not yes
                    response.sendRedirect("login.jsp");
                }
            } else {
                // null
                response.sendRedirect("login.jsp");
            }

        } catch (IOException | ServletException e) {
            e.getStackTrace();
        }
        
    }
}
