package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.dto.BandBookingDto;
import jak.dut.BookYourBand.exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.model.BandBooking;

import java.util.List;

public interface BandBookingService {

    void addBandBooking(BandBookingDto bandBookingDto) throws BookingUnavailableBandException;

    BandBooking getBandBookingById(Long id);

    List<BandBooking> getAllBandBookings();


}
