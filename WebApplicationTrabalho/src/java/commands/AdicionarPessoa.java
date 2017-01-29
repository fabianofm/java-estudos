/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.PessoaDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author fabia
 */
public class AdicionarPessoa implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            // pegando os parâmetros do request
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String dataEmTexto = request.getParameter("dataNascimento");
            Calendar dataNascimento = null;

            // fazendo a conversão da data 
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);

            // monta um objeto contato
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            //pessoa.setDataNascimento(data.getTime());
            pessoa.setDataNascimento(dataNascimento.getTime());

            PessoaDAO dao = new PessoaDAO();
            dao.salvar(pessoa);

            RequestDispatcher d = request.getRequestDispatcher("/pessoa-adicionado.jsp");
            d.forward(request, response);

        } catch (IOException | ServletException e) {
            e.getStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(AdicionarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
