package info.vividcode.web.app.jerseysample.controllers

import javax.inject.Inject
import javax.mvc.Models
import javax.mvc.annotation.Controller
import javax.mvc.annotation.View
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

/**
 * Root resource, which represents ÅgHello world!Åh.
 */
@Controller
@Path("/kotlin")
class Kotlin {

    @Inject

    @GET
    @Produces("text/html; charset=utf-8")
    @View("kotlin.jsp")
    fun getText(): Unit {
        //return Response.ok("This is kotlin test!!").build();
    }

}
