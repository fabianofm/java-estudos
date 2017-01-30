/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            String senha = request.getParameter("senha");
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
            pessoa.setSenha(convertStringToMd5(senha));
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

    public static String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuilder sb = new StringBuilder();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
// TODO Auto-generated catch block
            return null;
        }
        // TODO Auto-generated catch block

    }

}
