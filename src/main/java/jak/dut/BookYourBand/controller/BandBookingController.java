package jak.dut.BookYourBand.controller;

import jak.dut.BookYourBand.dto.BandBookingDto;
import jak.dut.BookYourBand.exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.model.BandBooking;
import jak.dut.BookYourBand.repository.BandBookingRepository;
import jak.dut.BookYourBand.service.BandBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bandbooking")
public class BandBookingController {

    private final BandBookingService bandBookingService;
    private final BandBookingRepository bandBookingRepository;

    public BandBookingController(BandBookingService bandBookingService, BandBookingRepository bandBookingRepository) {
        this.bandBookingService = bandBookingService;
        this.bandBookingRepository = bandBookingRepository;
    }

    @GetMapping("/choosedateandband")
    public String chooseDateAndBand(Model model) {
        model.addAttribute("bandBooking", new BandBooking());
        return "choosedateandband";
    }

    @PostMapping("/reserve")
    public String addBandBooking(BandBookingDto bandBookingDto) throws BookingUnavailableBandException {
            bandBookingService.addBandBooking(bandBookingDto);
            return "bandreservation";
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
