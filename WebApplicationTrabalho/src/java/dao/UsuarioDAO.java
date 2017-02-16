package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.Usuario;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a
 * entity Usuario.
 */
public class UsuarioDAO {

    private static UsuarioDAO instance;
    protected EntityManager entityManager;

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }

        return instance;
    }

    public UsuarioDAO() {
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
     * Método utilizado para salvar ou atualizar as informações de uma Usuario.
     *
     * @param Usuario
     * @return
     *
     */
    public Usuario salvar(Usuario Usuario) {

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(Usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return Usuario;
    }

    /**
     * Método utilizado para atualizar as informações de um Usuario.
     *
     * @param Usuario
     * @return
     *
     */
    public Usuario editar(Usuario Usuario) {
        // EntityManager entityManager = getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.merge(Usuario);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return Usuario;
    }

    /**
     * Método que apaga a Usuario do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {

        try {
            entityManager.getTransaction().begin();
            Usuario Usuario = entityManager.find(Usuario.class, id);
            entityManager.remove(Usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {

        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        Query q = entityManager.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public Usuario findUsuario(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    public List<Usuario> findUsuarioLogin(String login) {

        Query q = entityManager.createQuery("SELECT u FROM Usuario u WHERE "
                + "u.login = :login ");
        q.setParameter("login", login);
        List<Usuario> ls = q.getResultList();
        return q.getResultList();
    }

    public Usuario login(String login, String senha) {
        Query q = entityManager.createQuery("SELECT u from Usuario u WHERE "
                + "u.login = :login AND u.senha = :senha ");
        q.setParameter("login", login);
        q.setParameter("senha", senha);

        List<Usuario> ls = q.getResultList();

        if (ls.size() == 1) {
            return ls.get(0);
        }
        return null;
    }

}
