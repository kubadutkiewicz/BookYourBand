package jak.dut.BookYourBand.Repository;

import jak.dut.BookYourBand.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Token findByValue(String value);

}