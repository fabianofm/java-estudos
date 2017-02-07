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

/**
 *
 * @author fabia
 */
public class ListarUsuarios implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {

            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/listar-usuarios.jsp");
            d.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getStackTrace();
        }
        
    }
}