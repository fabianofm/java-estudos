/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.CestaDAO;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
        try {
            // pegando os parâmetros do request
            //String login = request.getParameter("login");
            Integer id = Integer.parseInt(request.getParameter("id"));

            CestaDAO dao = new CestaDAO();

            List<Cesta> loginOfItem = dao.findLogin(id);
            
            while (lo/*ginOfItem*/.next()) {
                String s1 = rs.getString("login");
                
            }
           
           // for (Cesta cesta : loginOfItem) {
             //   String loginCesta = cesta.getLogin();
                
           //}
                HttpSession session = request.getSession();

                Object loginFlag = session.getAttribute("login");
                if (loginFlag != null) {
                    String loginFlagStr = String.valueOf(loginFlag);
                    if ("fulano".equalsIgnoreCase(loginFlagStr)) {
                        request.setAttribute("actionDebug", "hi");
                        RequestDispatcher d = request.getRequestDispatcher("sucesso.jsp");
                        d.forward(request, response);
                    } else {
                        // not yes
                        response.sendRedirect("login.jsp");
                    }
                } else {
                    // null
                    response.sendRedirect("login.jsp");
                }
            

            //dao.excluir(id);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
