/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author fabia
 */
import commands.AdicionarUsuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import dao.UsuarioDAO;
import java.util.Date;
import model.Usuario;

/**
 * Classe utilizada para testar os métodos do UsuarioDAO.
 */
public class Teste {

    public static void main(String[] args) throws Exception {

        Usuario Usuario = new Usuario();

        Calendar data = new GregorianCalendar();
        Date now = new Date();

        Usuario.setNome("Fabiano");
        data.set(Calendar.YEAR, 1983);
        data.set(Calendar.MONTH, 11);
        data.set(Calendar.DAY_OF_MONTH, 26);
        Usuario.setDataCadastro(now);
        Usuario.setDataNascimento(data.getTime());
        Usuario.setEmail("rafael.sakurai@metodista.br");
        Usuario.setLogin("fabi");
        Usuario.setSenha(AdicionarUsuario.convertStringToMd5("123"));

        UsuarioDAO dao = new UsuarioDAO();
        System.out.println("Salvando a Usuario: " + Usuario.getNome());
        Usuario = dao.salvar(Usuario);

        Usuario.setNome("Vitorino Salvieir");
        Usuario = dao.salvar(Usuario);
        System.out.println("Alterando a Usuario: " + Usuario.getNome());

        //Usuario Usuario2 = dao.consultarPorId(Usuario.getId());
        //System.out.println("Consultando: " + Usuario2.getNome());
        //System.out.println("Removendo a Usuario: " + Usuario.getId());
        //dao.excluir(Usuario.getId());
    }
}
