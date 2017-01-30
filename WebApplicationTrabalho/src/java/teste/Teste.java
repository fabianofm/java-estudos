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
import commands.AdicionarPessoa;
import java.util.Calendar;
import java.util.GregorianCalendar;
import dao.PessoaDAO;
import model.Pessoa;


/**
 * Classe utilizada para testar os métodos do PessoaDAO.
 */
public class Teste {

    public static void main(String[] args) throws Exception {
        
        
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fabiano");
        Calendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, 1983);
        data.set(Calendar.MONTH, 11);
        data.set(Calendar.DAY_OF_MONTH, 26);
        pessoa.setDataNascimento(data.getTime());
        pessoa.setEmail("rafael.sakurai@metodista.br");
       pessoa.setSenha(AdicionarPessoa.convertStringToMd5("123"));

        PessoaDAO dao = new PessoaDAO();
        System.out.println("Salvando a pessoa: " + pessoa.getNome());
        pessoa = dao.salvar(pessoa);

        pessoa.setNome("Vitorino Salvieir");
        pessoa = dao.salvar(pessoa);
        System.out.println("Alterando a pessoa: " + pessoa.getNome());

        //Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
        //System.out.println("Consultando: " + pessoa2.getNome());

        //System.out.println("Removendo a pessoa: " + pessoa.getId());
        //dao.excluir(pessoa.getId());
    }
}
