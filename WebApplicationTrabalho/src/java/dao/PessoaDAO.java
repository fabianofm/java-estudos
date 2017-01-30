/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import commands.AdicionarPessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Pessoa;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a entity Pessoa.
 */
public class PessoaDAO {
 /**
   * Método utilizado para obter o entity manager.
   * @return
   */
  private EntityManager getEntityManager() {
    EntityManagerFactory factory = null;
    EntityManager entityManager = null;
    try {
      //Obtém o factory a partir da unidade de persistência.
      factory = Persistence.createEntityManagerFactory("ProjetoFrontControllerPU");
      //Cria um entity manager.
      entityManager = factory.createEntityManager();
      //Fecha o factory para liberar os recursos utilizado.
    } finally {
      //factory.close();
    }
    return entityManager;
  }

  /**
   * Método utilizado para salvar ou atualizar as informações de uma pessoa.
   * @param pessoa
   * @return
   * @throws java.lang.Exception
   */
  public Pessoa salvar(Pessoa pessoa) throws Exception {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      System.out.println("Salvando a pessoa.");
      // Verifica se a pessoa ainda não está salva no banco de dados.
      if(pessoa.getId() == null) {
        //Salva os dados da pessoa.
        entityManager.persist(pessoa);
      } else {
        //Atualiza os dados da pessoa.
        pessoa = entityManager.merge(pessoa);
      }
      // Finaliza a transação.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
    return pessoa;
  }

  /**
   * Método que apaga a pessoa do banco de dados.
   * @param id
   */
  public void excluir(Long id) {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      // Consulta a pessoa na base de dados através do seu ID.
      Pessoa pessoa = entityManager.find(Pessoa.class, id);
      System.out.println("Excluindo os dados de: " + pessoa.getNome());
      // Remove a pessoa da base de dados.
      entityManager.remove(pessoa);
      // Finaliza a transação.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
  }

  public List<Pessoa> findPessoaEntities() {
        return findPessoaEntities(true, -1, -1);
    }

    public List<Pessoa> findPessoaEntities(int maxResults, int firstResult) {
        return findPessoaEntities(false, maxResults, firstResult);
    }

    private List<Pessoa> findPessoaEntities(boolean all, int maxResults, int firstResult) {
    
        EntityManager entityManager = getEntityManager();
        try {
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoa.class));
            Query q = entityManager.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Pessoa findPessoa(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Pessoa.class, id);
        } finally {
            entityManager.close();
        }
    }
 /*
    public int getPessoaCount() {
        try {
            EntityManager entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            Root<Pessoa> rt = cq.from(Pessoa.class);
            cq.select(entityManager.getCriteriaBuilder().count(rt));
            Query q = entityManager.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            entityManager.close();
        }
    }
*/
    public Pessoa login(String nome, String senha) {
         EntityManager entityManager = getEntityManager();
        Query q = entityManager.createQuery("SELECT p from Pessoa p WHERE "
                + "p.nome = :nome AND p.senha = :senha ");
        
        senha = AdicionarPessoa.convertStringToMd5(senha);
        q.setParameter("nome", nome);
        q.setParameter("senha", senha);

        List<Pessoa> ls = q.getResultList();

        if (ls.size() == 1) {
            return ls.get(0);
        }
        return null;
    }

  
  
}