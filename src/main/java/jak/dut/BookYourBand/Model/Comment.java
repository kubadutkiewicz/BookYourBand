package jak.dut.BookYourBand.Model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bandId;
    private String commentContent;
    private String login;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "bandId", insertable = false, updatable = false)
    private Band band;

    public Comment() {
    }

    public Comment(Long id, Long bandId, String commentContent, String login, Integer rating, Band band) {
        this.id = id;
        this.bandId = bandId;
        this.commentContent = commentContent;
        this.login = login;
        this.rating = rating;
        this.band = band;
    }

        public Comment(Long bandId, String commentContent, String login, Integer rating, Band band) {
        this.bandId = bandId;
        this.commentContent = commentContent;
        this.login = login;
        this.rating = rating;
        this.band = band;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", bandId=" + bandId +
                ", commentContent='" + commentContent + '\'' +
                ", login='" + login + '\'' +
                ", rating=" + rating +
                ", band=" + band +
                '}';
    }
}
