package jak.dut.BookYourBand.controller;

import jak.dut.BookYourBand.dto.CommentDto;
import jak.dut.BookYourBand.exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.model.Comment;
import jak.dut.BookYourBand.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/write")
    public String writeYourComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "writeyourcomment";
    }

    @PostMapping("/add")
    public String addComment(CommentDto commentDto) throws BookingUnavailableBandException {
        commentService.addComment(commentDto);
        return "commentadded";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public List<Comment> getAllCommentsForBand(@PathVariable("id") Long bandId) {
        return commentService.findAllCommentsByBandId(bandId);
    }
}
