package info.vividcode.web.app.jerseysample.controllers;

import javax.enterprise.context.RequestScoped;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Root resource, which represents “Hello world!”.
 */
@RequestScoped
//@Controller
@Path("/")
public class Root {
    @Controller
    @GET
    @Produces("text/plain")
    public Response getText() {
        return Response.ok("Hello world!").build();
    }

    @Controller
    @Path("good")
    @GET
    @Produces("text/plain")
    public String getGood() {
        return "root.jsp";
    }

}
