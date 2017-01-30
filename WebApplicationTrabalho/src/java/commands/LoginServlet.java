/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.PessoaDAO;

/**
 *
 * @author 
 */
public class LoginServlet implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            
            PessoaDAO dao = new PessoaDAO();

            if (dao.login(nome, senha) != null) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("nome", nome);
                response.sendRedirect(request.getContextPath()+"/pessoa.jsp");
            } else {
                request.setAttribute("ERR", "Loi");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            
        } catch (IOException | ServletException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                request.getSession().invalidate();
                response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
            } catch (IOException ex1) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}