package commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ServicosOpcionaisDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import model.ServicosOpcionais;

/**
 *
 * @author fabia
 */
public class AdicionarServicoOpcional implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");

        ServicosOpcionais ServicosOpcionais = new ServicosOpcionais();
        ServicosOpcionais.setNome(nome);
        ServicosOpcionais.setTipo(tipo);

        ServicosOpcionaisDAO dao = new ServicosOpcionaisDAO();

        try {
            dao.salvar(ServicosOpcionais);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdicionarServicoOpcional.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
