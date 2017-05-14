package it.eomm.hello.jaxws;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPBinding;
import java.io.File;

// This define the binding of the request/reponse
@BindingType(value = SOAPBinding.SOAP11HTTP_MTOM_BINDING)
// This parameters define the QName of the service
@WebService(serviceName = IHelloService.SERVICE_NAME, endpointInterface = IHelloService.ENDPOINT)
// This is needed for 
public class ServiceImpl implements IHelloService {

    public String helloWorld(String name) {
        return "Hi ".concat(name);
    }

    public String uploadFile(File data) {
        if (data != null) {
            return "Upload Successful: " + data.getAbsolutePath();
        }
        throw new WebServiceException("Upload Failed!");
    }

}
