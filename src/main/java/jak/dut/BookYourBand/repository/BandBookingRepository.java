package jak.dut.BookYourBand.repository;

import jak.dut.BookYourBand.model.BandBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandBookingRepository extends JpaRepository<BandBooking, Long> {

    BandBooking findBandBookingById(Long id);

}
