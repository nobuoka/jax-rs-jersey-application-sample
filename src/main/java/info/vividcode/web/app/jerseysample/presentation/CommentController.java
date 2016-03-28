package info.vividcode.web.app.jerseysample.presentation;

import info.vividcode.web.app.jerseysample.application.CommentApplication;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/comments")
@RequestScoped
public class CommentController {

    @Inject
    private CommentApplication mCommentApplication;

    @GET
    @Produces("text/plain")
    public Response getComments() {
        mCommentApplication.createComment("yes");
        String content = "A number of comments : " + mCommentApplication.readComments().size();
        return Response.ok(content).build();
    }

}
