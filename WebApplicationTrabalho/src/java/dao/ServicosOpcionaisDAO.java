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
import model.ServicosOpcionais;
import model.Usuario;

/**
 *
 * @author fabia
 */
public class ServicosOpcionaisDAO {

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
     * Método utilizado para salvar ou atualizar as informações de um ServicosOpcionais.
     *
     * @param ServicosOpcionais
     * @return
     * @throws java.lang.Exception
     */
    public ServicosOpcionais salvar(ServicosOpcionais ServicosOpcionais) throws Exception {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            System.out.println("Salvando a ServicosOpcionais.");
            // Verifica se a ServicosOpcionais ainda não está salva no banco de dados.
            if (ServicosOpcionais.getId() == null) {
                //Salva os dados da ServicosOpcionais.
                entityManager.persist(ServicosOpcionais);
            } else {
                //Atualiza os dados da ServicosOpcionais.
                ServicosOpcionais = entityManager.merge(ServicosOpcionais);
            }
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return ServicosOpcionais;
    }

    /**
     * Método que apaga um ServicosOpcionais do banco de dados.
     *
     * @param id
     */
    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            // Consulta a ServicosOpcionais na base de dados através do seu ID.
            ServicosOpcionais ServicosOpcionais = entityManager.find(ServicosOpcionais.class, id);
            System.out.println("Excluindo os dados de: " + ServicosOpcionais.getNome());
            // Remove a ServicosOpcionais da base de dados.
            entityManager.remove(ServicosOpcionais);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public List<ServicosOpcionais> findServicosOpcionaisEntities() {
        return findServicosOpcionaisEntities(true, -1, -1);
    }

    public List<ServicosOpcionais> findServicosOpcionaisEntities(int maxResults, int firstResult) {
        return findServicosOpcionaisEntities(false, maxResults, firstResult);
    }

    private List<ServicosOpcionais> findServicosOpcionaisEntities(boolean all, int maxResults, int firstResult) {

        EntityManager entityManager = getEntityManager();
        try {
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicosOpcionais.class));
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

    public ServicosOpcionais findServicosOpcionais(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(ServicosOpcionais.class, id);
        } finally {
            entityManager.close();
        }
    }

}
