/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ServicosOpcionaisDAO;
import model.ServicosOpcionais;

/**
 *
 * @author fabia
 */
public class AdicionarServicoOpcional implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            // pegando os parâmetros do request
            String nome = request.getParameter("nome");
            String tipo = request.getParameter("tipo");
            

            // monta um objeto contato
            ServicosOpcionais ServicosOpcionais = new ServicosOpcionais();
            ServicosOpcionais.setNome(nome);
            ServicosOpcionais.setTipo(tipo);
            

            ServicosOpcionaisDAO dao = new ServicosOpcionaisDAO();
            dao.salvar(ServicosOpcionais);

            RequestDispatcher d = request.getRequestDispatcher("/sucesso.jsp");
            d.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(AdicionarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
