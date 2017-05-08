package it.eomm.hello.jdo.test;

import it.eomm.hello.jdo.business.BookDao;
import it.eomm.hello.jdo.model.Inventory;
import it.eomm.hello.jdo.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Manuel Spigolon on 08/05/2017.
 */
public class TestJdo {


    private BookDao crud;

    /**
     * This method is executed BEFORE each `@Test`
     */
    @Before
    public void before() {
        crud = new BookDao();
    }

    @Test
    public void insertInventory() {
        Inventory insert = new Inventory("New Inventory");
        Product product = new Product("Hello", "Hello World", 11.99);
        insert.getProducts().add(product);

        // assert the id doesn't exist
        Assert.assertNotNull(product);
        insert = crud.insert(insert);

        // assert the id has been set
        Assert.assertNotNull(product.getId());

        // TODO
    }

}
