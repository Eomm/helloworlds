package it.eomm.hello.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.soap.MTOM;
import java.io.File;

@WebService
// SOAP Message Transmission Optimized Mechanism for send binary data
@MTOM(enabled = true, threshold = 32768)
// We use DOCUMENT/Wrapper Literal comunication
@SOAPBinding(style = Style.DOCUMENT)
public interface IHelloService {

    public static final String SERVICE_NAME = "HelloWorld";
    public static final String NAMESPACE_URI = "http://jaxws.hello.eomm.it/";
    public static final String ENDPOINT = "it.eomm.hello.jaxws.IHelloService";

    @WebMethod
    @WebResult(name = "hi")
    String helloWorld(@WebParam(name = "sayHalloTo") String name);

    @WebMethod
    @WebResult(name = "info")
    String uploadFile(@WebParam(name = "uploadFile") File data);

}
