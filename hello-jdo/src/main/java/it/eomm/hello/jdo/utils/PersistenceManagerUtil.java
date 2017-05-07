package it.eomm.hello.jdo.utils;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
public class PersistenceManagerUtil {

    public static final String PERSISTENCE_UNIT_NAME = "hello-jdo-pu";

    private static PersistenceManager persistenceManager;

    private PersistenceManagerUtil() {
    }

    public static PersistenceManager getEntityManager() {
        if (persistenceManager == null) {
            // the same in persistence.xml

            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(PERSISTENCE_UNIT_NAME);
            persistenceManager = pmf.getPersistenceManager();
        }
        return persistenceManager;
    }


}
