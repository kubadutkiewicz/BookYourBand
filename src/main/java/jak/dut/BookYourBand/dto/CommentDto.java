package jak.dut.BookYourBand.dto;

public class CommentDto {

    private final String commentText;
    private final Double rating;
    private final String bandName;

    public CommentDto(String commentText, Double rating, String bandName) {
        this.commentText = commentText;
        this.rating = rating;
        this.bandName = bandName;
    }

    public String getCommentText() {
        return commentText;
    }

    public Double getRating() {
        return rating;
    }

    public String getBandName() {
        return bandName;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentText='" + commentText + '\'' +
                ", rating=" + rating +
                ", bandName='" + bandName + '\'' +
                '}';
    }
}
