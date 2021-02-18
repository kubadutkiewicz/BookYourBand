package jak.dut.BookYourBand.Controller;

import jak.dut.BookYourBand.Exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.Model.Band;
import jak.dut.BookYourBand.Model.BandBooking;
import jak.dut.BookYourBand.Model.Client;
import jak.dut.BookYourBand.Repository.BandBookingRepository;
import jak.dut.BookYourBand.Service.BandBookingService;
import jak.dut.BookYourBand.Service.BandBookingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bandbooking")
public class BandBookingController {

    private BandBookingService bandBookingService;
    private BandBookingRepository bandBookingRepository;
    private BandBookingServiceImpl bandBookingServiceImpl;

    public BandBookingController(BandBookingService bandBookingService, BandBookingRepository bandBookingRepository) {
        this.bandBookingService = bandBookingService;
        this.bandBookingRepository = bandBookingRepository;
    }

    @PostMapping("/reserve")
    public String addBandBooking(Client client, @RequestBody Band band, @RequestBody String date) throws BookingUnavailableBandException {
            BandBooking bandBooking = bandBookingServiceImpl.addBandBooking(client.getId(), band.getId(), date);
            return bandBooking.toString();
    }

    @GetMapping("/booking")
    public BandBooking getBookingById(Long bookingId) {
        return bandBookingRepository.findBandBookingById(bookingId);
    }

    @GetMapping("/allbookings")
    public List<BandBooking> getAllBookings() {
        return bandBookingService.getAllBandBookings();
    }
}
