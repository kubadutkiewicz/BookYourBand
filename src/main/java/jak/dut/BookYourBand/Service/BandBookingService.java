package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.Model.BandBooking;

import java.util.List;

public interface BandBookingService {

    BandBooking addBandBooking(Long clientId, Long bandId, String date) throws BookingUnavailableBandException;

    BandBooking getBandBookingById(Long id);

    List<BandBooking> getAllBandBookings();


}
