package jak.dut.BookYourBand.Repository;

import jak.dut.BookYourBand.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findAllByBandId(@Param("bandId") Long bandId);

}
