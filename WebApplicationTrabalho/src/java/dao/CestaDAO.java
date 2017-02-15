/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.Cesta;

/**
 *
 * @author fabiano
 */
public class CestaDAO {

    /**
     * Método utilizado para obter o entity manager.
     *
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
     * Método utilizado para salvar ou atualizar as informações de uma Cesta.
     *
     * @param Cesta
     * @return
     * @throws java.lang.Exception
     */
    public Cesta salvar(Cesta Cesta) throws Exception {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            System.out.println("Salvando a Cesta.");
            // Verifica se a Cesta ainda não está salva no banco de dados.
            if (Cesta.getId() == null) {
                //Salva os dados da Cesta.
                entityManager.persist(Cesta);
            } else {
                //Atualiza os dados da Cesta.
                Cesta = entityManager.merge(Cesta);
            }
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return Cesta;
    }

    /**
     * Método que apaga um Cesta do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            // Consulta a Cesta na base de dados através do seu ID.
            Cesta Cesta = entityManager.find(Cesta.class, id);
            System.out.println("Excluindo os dados de: " + Cesta.getLogin());
            // Remove a Cesta da base de dados.
            entityManager.remove(Cesta);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public List<Cesta> findCestaEntities() {
        return findCestaEntities(true, -1, -1);
    }

    public List<Cesta> findCestaEntities(int maxResults, int firstResult) {
        return findCestaEntities(false, maxResults, firstResult);
    }

    private List<Cesta> findCestaEntities(boolean all, int maxResults, int firstResult) {

        EntityManager entityManager = getEntityManager();
        try {
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cesta.class));
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

    public Cesta findCesta(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Cesta.class, id);
        } finally {
            entityManager.close();
        }
    }
    



    public List<Cesta> findItens(String login) {
        EntityManager entityManager = getEntityManager();
        Query q = entityManager.createQuery("SELECT c FROM Cesta c WHERE "
                + "c.login = :login ");

        q.setParameter("login", login);

        List<Cesta> ls = q.getResultList();

       
            return q.getResultList();
        
       
    }
    
    
    public Cesta login(Integer id) {
         EntityManager entityManager = getEntityManager();
        Query q = entityManager.createQuery("SELECT c from Cesta c WHERE "
                + "c.id = :id ");
       
        q.setParameter("id", id);

        List<Cesta> ls = q.getResultList();

        if (ls.size() == 1) {
            return ls.get(0);
        }
        return null;
    }

}
