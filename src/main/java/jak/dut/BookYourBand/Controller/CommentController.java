package jak.dut.BookYourBand.Controller;

import jak.dut.BookYourBand.Model.Comment;
import jak.dut.BookYourBand.Service.CommentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = { "/all/{bandId}" })
    @ResponseBody
    public List<Comment> findAllForBand(@PathVariable Long bandId) {
        return commentService.findAllCommentsForBand(bandId);
    }

    @PostMapping(value = { "/{bandId}" })
    @ResponseBody
    public void addCommentForBand(@PathVariable Long bandId, @RequestBody Comment comment) {
        commentService.addComment(comment);
    }
}
