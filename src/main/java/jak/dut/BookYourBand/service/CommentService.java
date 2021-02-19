package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.dto.CommentDto;
import jak.dut.BookYourBand.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(CommentDto commentDto);

    List<Comment> findAllCommentsByBandId(Long bandId);

}
