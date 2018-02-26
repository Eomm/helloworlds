package it.eomm.hello.jaxrs.test;

import it.eomm.hello.jaxrs.HelloRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class TestJaxRs extends JerseyTest {

    @Override
    protected Application configure() {
        set(TestProperties.LOG_TRAFFIC, true);
        set(TestProperties.DUMP_ENTITY, true);
        return new ResourceConfig(HelloRest.class);
    }

    @Test
    public void testHello() {
        String response = target("hello/World").request().get(String.class);
        Assert.assertTrue("Hi World".equals(response));
    }

}
