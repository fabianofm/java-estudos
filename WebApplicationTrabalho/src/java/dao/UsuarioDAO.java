/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import commands.AdicionarUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Usuario;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a entity Usuario.
 */
public class UsuarioDAO {
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
   * Método utilizado para salvar ou atualizar as informações de uma Usuario.
   * @param Usuario
   * @return
   * @throws java.lang.Exception
   */
  public Usuario salvar(Usuario Usuario) throws Exception {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      System.out.println("Salvando a Usuario.");
      // Verifica se a Usuario ainda não está salva no banco de dados.
      if(Usuario.getId() == null) {
        //Salva os dados da Usuario.
        entityManager.persist(Usuario);
      } else {
        //Atualiza os dados da Usuario.
        Usuario = entityManager.merge(Usuario);
      }
      // Finaliza a transação.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
    return Usuario;
  }

  /**
   * Método que apaga a Usuario do banco de dados.
   * @param id
   */
  public void excluir(Long id) {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      // Consulta a Usuario na base de dados através do seu ID.
      Usuario Usuario = entityManager.find(Usuario.class, id);
      System.out.println("Excluindo os dados de: " + Usuario.getNome());
      // Remove a Usuario da base de dados.
      entityManager.remove(Usuario);
      // Finaliza a transação.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
  }

  public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
    
        EntityManager entityManager = getEntityManager();
        try {
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Usuario.class, id);
        } finally {
            entityManager.close();
        }
    }
 /*
    public int getUsuarioCount() {
        try {
            EntityManager entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(entityManager.getCriteriaBuilder().count(rt));
            Query q = entityManager.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            entityManager.close();
        }
    }
*/
    public Usuario login(String login, String senha) {
         EntityManager entityManager = getEntityManager();
        Query q = entityManager.createQuery("SELECT u from Usuario u WHERE "
                + "u.login = :login AND u.senha = :senha ");
        
        senha = AdicionarUsuario.convertStringToMd5(senha);
        q.setParameter("login", login);
        q.setParameter("senha", senha);

        List<Usuario> ls = q.getResultList();

        if (ls.size() == 1) {
            return ls.get(0);
        }
        return null;
    }

  
  
}