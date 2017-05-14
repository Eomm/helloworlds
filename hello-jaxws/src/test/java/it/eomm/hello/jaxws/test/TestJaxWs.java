package it.eomm.hello.jaxws.test;

import it.eomm.hello.jaxws.IHelloService;
import it.eomm.hello.jaxws.Publisher;
import it.eomm.hello.jaxws.ServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class TestJaxWs {


    private static IHelloService helloClient;

    @BeforeClass
    public static void exposeServices() throws Exception {
        try {
            Endpoint.publish(Publisher.PUBLIC_URL, new ServiceImpl());

            Service helloService = Service.create(//
                    new URL(Publisher.WSDL_URL), //
                    new QName(IHelloService.NAMESPACE_URI, IHelloService.SERVICE_NAME) //
            );

            helloClient = helloService.getPort(IHelloService.class);
        } catch (Exception ex) {
            // This may be throw some exception, like port in use
            ex.printStackTrace();
        }
    }

    @Test
    public void testHello() throws Exception {
        final String response = helloClient.helloWorld("World");
        Assert.assertEquals(response, "Hi World");
    }

    @Test
    public void testUpload() throws Exception {
        byte[] message = "SGVsbG8gV29ybGQ=".getBytes();
        File f = File.createTempFile("prefix-", "-suffix");

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(message);
        fos.close();

        final String response = helloClient.uploadFile(f);

        Assert.assertTrue(response.endsWith(f.getName()));
    }

}