package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Model.Comment;

import java.util.List;

public interface CommentService {

    public void addComment(Comment comment);

    public List<Comment> findAllCommentsForBand(Long bandId);
}
