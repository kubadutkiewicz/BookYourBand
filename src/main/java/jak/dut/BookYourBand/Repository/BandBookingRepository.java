package jak.dut.BookYourBand.Repository;

import jak.dut.BookYourBand.Model.BandBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandBookingRepository extends JpaRepository<BandBooking, Long> {

    BandBooking findBandBookingById(Long id);

}
