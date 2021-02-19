package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.dto.CommentDto;
import jak.dut.BookYourBand.model.Band;
import jak.dut.BookYourBand.model.Comment;
import jak.dut.BookYourBand.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final BandService bandService;
    private final ClientService clientService;

    public CommentServiceImpl(CommentRepository commentRepository, BandService bandService, ClientService clientService) {
        this.commentRepository = commentRepository;
        this.bandService = bandService;
        this.clientService = clientService;
    }

    @Override
    public void addComment(CommentDto commentDto) {
        Comment newComment = new Comment();
        newComment.setCommentText(commentDto.getCommentText());
        newComment.setRating(commentDto.getRating());
        String bandName = commentDto.getBandName();
        Band bandByName = bandService.getBandByName(bandName);
        newComment.setBand(bandByName);
        newComment.setClient(clientService.getClientByName(clientService.getCurrentClient()));
        commentRepository.save(newComment);
    }

    @Override
    public List<Comment> findAllCommentsByBandId(Long bandId) {
        return commentRepository.findAllByBandId(bandId);
    }
}
