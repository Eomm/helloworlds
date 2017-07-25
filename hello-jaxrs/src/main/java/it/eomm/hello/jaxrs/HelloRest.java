package it.eomm.hello.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloRest {

    @GET
    @Path("/{param}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Hi " + msg;
        return Response.status(200).entity(output).build();
    }

}
