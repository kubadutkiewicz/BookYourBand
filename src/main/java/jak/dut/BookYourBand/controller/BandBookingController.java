package jak.dut.BookYourBand.controller;

import jak.dut.BookYourBand.dto.BandBookingDto;
import jak.dut.BookYourBand.exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.model.BandBooking;
import jak.dut.BookYourBand.repository.BandBookingRepository;
import jak.dut.BookYourBand.service.BandBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dateandband")
    public String chooseDateAndBand(Model model) {
        model.addAttribute("bandBooking", new BandBooking());
        return "dateandband";
    }

    @PostMapping("/reserve")
    public String addBandBooking(BandBookingDto bandBookingDto) throws BookingUnavailableBandException {
            bandBookingService.addBandBooking(bandBookingDto);
            return "bandreservation";
    }

    @GetMapping("/booking/{id}")
    @ResponseBody
    public BandBooking getBookingById(@PathVariable("id") Long id) {
        return bandBookingRepository.findBandBookingById(id);
    }

    @GetMapping("/allbookings")
    @ResponseBody
    public List<BandBooking> getAllBookings() {
        return bandBookingService.getAllBandBookings();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public List<BandBooking> getAllBandBookingForBand(@PathVariable("id") Long bandId) {
        return bandBookingService.getAllBandBookingsForBand(bandId);
    }
}
