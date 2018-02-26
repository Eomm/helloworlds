package it.eomm.hello.jdo.utils;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/**
 * Created by Manuel Spigolon on 07/05/2017.
 */
public class PersistenceManagerUtil {

    // the same in jdoconfig.xml
    public static final String PERSISTENCE_UNIT_NAME = "hello-jdo-pm";

    private static PersistenceManager persistenceManager;

    private PersistenceManagerUtil() {
    }

    public static PersistenceManager getEntityManager() {
        if (persistenceManager == null) {
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(PERSISTENCE_UNIT_NAME);
            persistenceManager = pmf.getPersistenceManager();
        }
        return persistenceManager;
    }

    /**
     * Closing a PersistenceManager might release it to the pool of available PersistenceManagers,
     * or might be garbage collected, at the option of the JDO implementation.
     */
    public static void release() {
        if (persistenceManager != null) {
            persistenceManager.close();
        }
    }


}
