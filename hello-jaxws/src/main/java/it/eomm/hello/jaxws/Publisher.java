package it.eomm.hello.jaxws;


import javax.xml.ws.Endpoint;

public class Publisher {

    public static final String PUBLIC_URL = "http://localhost:9999/ws/strange/name";
    public static final String WSDL_URL = PUBLIC_URL + "?wsdl";

    public static void main(String[] args) {
        Endpoint.publish(PUBLIC_URL, new ServiceImpl());
    }

}