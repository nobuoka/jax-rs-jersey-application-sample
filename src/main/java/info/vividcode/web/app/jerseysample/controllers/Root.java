package info.vividcode.web.app.jerseysample.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Root resource, which represents “Hello world!”.
 */
@Path("/")
public class Root {

    @GET
    @Produces("text/plain")
    public Response getText() {
        return Response.ok("Hello world!").build();
    }

}
