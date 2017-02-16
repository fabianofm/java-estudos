package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.ServicosOpcionais;

/**
 *
 * @author fabia
 */
public class ServicosOpcionaisDAO {

    private static ServicosOpcionaisDAO instance;
    protected EntityManager entityManager;

    public static ServicosOpcionaisDAO getInstance() {
        if (instance == null) {
            instance = new ServicosOpcionaisDAO();
        }
        return instance;
    }

    public ServicosOpcionaisDAO() {
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
     * Método utilizado para salvar ou atualizar as informações de um
     * ServicosOpcionais.
     *
     * @param ServicosOpcionais
     * @return
     */
    public ServicosOpcionais salvar(ServicosOpcionais ServicosOpcionais) {

        try {

            entityManager.getTransaction().begin();

            if (ServicosOpcionais.getId() == null) {
                entityManager.persist(ServicosOpcionais);
            } else {
                ServicosOpcionais = entityManager.merge(ServicosOpcionais);
            }
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return ServicosOpcionais;
    }

    /**
     * Método que apaga um ServicosOpcionais do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {

        try {
            entityManager.getTransaction().begin();
            ServicosOpcionais ServicosOpcionais = entityManager.find(ServicosOpcionais.class, id);
            System.out.println("Excluindo os dados de: " + ServicosOpcionais.getNome());
            entityManager.remove(ServicosOpcionais);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<ServicosOpcionais> findServicosOpcionaisEntities() {
        return findServicosOpcionaisEntities(true, -1, -1);
    }

    public List<ServicosOpcionais> findServicosOpcionaisEntities(int maxResults, int firstResult) {
        return findServicosOpcionaisEntities(false, maxResults, firstResult);
    }

    private List<ServicosOpcionais> findServicosOpcionaisEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ServicosOpcionais.class));
        Query q = entityManager.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public ServicosOpcionais findServicosOpcionais(Long id) {
        return entityManager.find(ServicosOpcionais.class, id);
    }

}
