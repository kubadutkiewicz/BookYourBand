package jak.dut.BookYourBand.repository;

import jak.dut.BookYourBand.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

    Band findBandById(Long id);

    Optional<Band> findBandByBandName(String bandName);

}
