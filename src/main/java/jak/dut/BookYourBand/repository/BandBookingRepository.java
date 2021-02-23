package jak.dut.BookYourBand.repository;

import jak.dut.BookYourBand.model.BandBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandBookingRepository extends JpaRepository<BandBooking, Long> {

    BandBooking findBandBookingById(Long id);

    List<BandBooking> findBandBookingByBandId(@Param("bandId") Long bandId);

}
