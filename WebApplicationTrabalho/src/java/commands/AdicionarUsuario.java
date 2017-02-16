package commands;

import dao.UsuarioDAO;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author fabia
 */
public class AdicionarUsuario implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
        } catch (ParseException ex) {
            Logger.getLogger(AdicionarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(date);
        Date now = new Date();

        Usuario Usuario = new Usuario();
        UsuarioDAO dao = UsuarioDAO.getInstance();

        Usuario.setNome(nome);
        Usuario.setEmail(email);
        Usuario.setLogin(login);
        Usuario.setSenha(senha);
        Usuario.setDataCadastro(now);
        Usuario.setDataNascimento(dataNascimento.getTime());

        try {
            dao.salvar(Usuario);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdicionarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
