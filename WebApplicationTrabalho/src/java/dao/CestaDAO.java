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

    private static CestaDAO instance;
    protected EntityManager entityManager;

    public static CestaDAO getInstance() {
        if (instance == null) {
            instance = new CestaDAO();
        }

        return instance;
    }

    public CestaDAO() {
        entityManager = getEntityManager();
    }

    /**
     * Método padrão de projeto Singleton que garante que apenas uma instância
     * dessa classe será criada durante toda a aplicação.
     *
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoFrontControllerPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    /**
     * Método utilizado para salvar ou atualizar as informações de uma Cesta.
     *
     * @param Cesta
     * @return
     */
    public Cesta salvar(Cesta Cesta) {

        try {
            entityManager.getTransaction().begin();

            if (Cesta.getId() == null) {
                entityManager.persist(Cesta);
            } else {
                Cesta = entityManager.merge(Cesta);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return Cesta;
    }

    /**
     * Método que apaga um Cesta do banco de dados.
     *
     * @param id
     */
    public void excluir(Integer id) {

        try {
            entityManager.getTransaction().begin();
            Cesta Cesta = entityManager.find(Cesta.class, id);
            entityManager.remove(Cesta);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Cesta> findCestaEntities() {
        return findCestaEntities(true, -1, -1);
    }

    public List<Cesta> findCestaEntities(int maxResults, int firstResult) {
        return findCestaEntities(false, maxResults, firstResult);
    }

    private List<Cesta> findCestaEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cesta.class));
        Query q = entityManager.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Cesta findCesta(Long id) {
        return entityManager.find(Cesta.class, id);
    }

    public List<Cesta> findItens(String login) {

        Query q = entityManager.createQuery("SELECT c FROM Cesta c WHERE "
                + "c.login = :login ");

        q.setParameter("login", login);
        List<Cesta> ls = q.getResultList();
        return q.getResultList();
    }

    public List<Cesta> findLogin(Integer id) {

        Query q = entityManager.createQuery("SELECT c.login from Cesta c WHERE "
                + "c.id = :id ");
        q.setParameter("id", id);
        List<Cesta> ls = q.getResultList();

        return q.getResultList();
    }
}
