package info.vividcode.web.app.jerseysample.application;

import info.vividcode.web.app.jerseysample.entities.Comment;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class CommentApplication {

    @PersistenceContext(unitName="jerseysample")
    private EntityManager mEntityManager;

    @Transactional
    public void createComment(String text) {
        Comment c = new Comment(text);
        mEntityManager.persist(c);
    }

    public List<Comment> readComments() {
        return (List<Comment>) mEntityManager.createNamedQuery("Comment.findAll").getResultList();
    }

}
