/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.CestaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            String login = request.getParameter("login");

            CestaDAO dao = new CestaDAO();

            dao.excluir(id);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
