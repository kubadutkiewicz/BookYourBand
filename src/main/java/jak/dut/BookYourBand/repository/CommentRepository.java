package jak.dut.BookYourBand.repository;

import jak.dut.BookYourBand.dto.CommentDto;
import jak.dut.BookYourBand.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByBandId(@Param("bandId") Long bandId);

}
