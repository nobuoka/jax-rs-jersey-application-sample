package info.vividcode.web.app.jerseysample.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="text")
    private String text;

    protected Comment() {}

    public Comment(String text) {
        this.text = text;
    }

    public long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

}
