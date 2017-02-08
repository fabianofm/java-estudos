/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.CestaDAO;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cesta;

/**
 *
 * @author fabiano
 */
public class AdicionarItemCesta implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            // pegando os parâmetros do request
            String login = request.getParameter("login");
            String[] item = request.getParameterValues("item");

            for (String ite : item) {
                Cesta Cesta = new Cesta();
                CestaDAO dao = new CestaDAO();

                Cesta.setLogin(login);
                Cesta.setItem(ite);

                dao.salvar(Cesta);
            }

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(AdicionarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
