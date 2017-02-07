/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fab
 */
public class Logout implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

 try {
            HttpSession session = request.getSession();

            if (!session.isNew()) {
               
                    session.invalidate();
                    session = request.getSession();
                    response.sendRedirect("index.jsp");
                
            }
} catch (IOException ex) {
                    Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
                }
     
    }
}
