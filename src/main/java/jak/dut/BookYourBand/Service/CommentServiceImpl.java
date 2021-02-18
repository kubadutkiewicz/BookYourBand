package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Model.Comment;
import jak.dut.BookYourBand.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllCommentsForBand(Long bandId) {
        return commentRepository.findAllByBandId(bandId);
    }
}
