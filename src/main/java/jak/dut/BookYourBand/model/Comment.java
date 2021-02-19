package jak.dut.BookYourBand.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;
    private Integer rating;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Band band;

    public Comment() {
    }

    public Comment(Long id, String commentText, Integer rating, Client client, Band band) {
        this.id = id;
        this.commentText = commentText;
        this.rating = rating;
        this.client = client;
        this.band = band;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
                ", commentText='" + commentText + '\'' +
                ", rating=" + rating +
                ", client=" + client +
                ", band=" + band +
                '}';
    }
}
