package info.vividcode.web.app.jerseysample.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Root resource, which represents “Hello world!”.
 */
@Controller
@Path("/")
@RequestScoped
public class Root {

    @Inject
    private Models models;

    @GET
    @Produces("text/html; charset=utf-8")
    public String getText() {
        return "kotlin.jsp";//return Response.ok("Hello world!??").build();
    }

}
