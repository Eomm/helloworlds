package it.eomm.hello.jdo.business;

import it.eomm.hello.jdo.model.Inventory;
import it.eomm.hello.jdo.utils.PersistenceManagerUtil;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

/**
 * Created by Manuel Spigolon on 08/05/2017.
 */
public class BookDao {


    public Inventory insert(Inventory inventory) {
        PersistenceManager pm = PersistenceManagerUtil.getEntityManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            pm.makePersistent(inventory);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        return inventory;
    }

}
