/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entities.model.CCTriangle;
import Entities.model.CCModel;
import Entities.model.CCNode;
import Entities.model.CCVertex;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author Chingo
 */
public final class CCWorkshopManager {

    /**
     * Instance of this class.
     */
    private static CCWorkshopManager instance;
    /**
     * The EntityManagerFactory.
     */
    private static EntityManagerFactory entityManagerFactory;

    /**
     * Private Constructor.
     */
    private CCWorkshopManager() {
        setUp();
    }

    /**
     * FIXME Check let this get checked.
     */
    private void setUp() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager
                    .getConnection("jdbc:sqlite:../DB/ccworkshop.db");
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CCWorkshopManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CCWorkshopManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        entityManagerFactory = Persistence
                .createEntityManagerFactory("ccworkshop");
    }

    /**
     * Creates a model manager if not exists and returns it.
     *
     * @return the modelmanager
     */
    public static CCWorkshopManager getInstance() {
        if (instance == null) {
            instance = new CCWorkshopManager();
        }
        return instance;
    }

    /**
     * Store model in database.
     *
     * @param model The model to store in database
     */
    public void save(final CCModel model) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(model);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public CCModel retrieve(Long id) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        
        entityManager.getTransaction().begin();
        CCModel result = entityManager.createQuery("from CCModel where id = " + id, CCModel.class).getSingleResult();
        System.out.println("id is: " + result.getId());
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
