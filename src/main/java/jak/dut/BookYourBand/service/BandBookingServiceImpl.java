package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.dto.BandBookingDto;
import jak.dut.BookYourBand.exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.model.Band;
import jak.dut.BookYourBand.model.BandBooking;
import jak.dut.BookYourBand.repository.BandBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandBookingServiceImpl implements BandBookingService {

    private final BandBookingRepository bandBookingRepository;
    private final BandService bandService;
    private final ClientService clientService;

    public BandBookingServiceImpl(BandBookingRepository bandBookingRepository, BandService bandService, ClientService clientService) {
        this.bandBookingRepository = bandBookingRepository;
        this.bandService = bandService;
        this.clientService = clientService;
    }

    @Override
    public void addBandBooking(BandBookingDto bandBookingDto) throws BookingUnavailableBandException {
        BandBooking newBooking = new BandBooking();
        newBooking.setDate(bandBookingDto.getDate());
        String bandName = bandBookingDto.getBandName();
        Band bandByName = bandService.getBandByName(bandName);
        newBooking.setBand(bandByName);
        newBooking.setClient(clientService.getClientByName(clientService.getCurrentClient()));
        bandBookingRepository.save(newBooking);
    }

    @Override
    public BandBooking getBandBookingById(Long id) {
        BandBooking bandBooking = bandBookingRepository.findBandBookingById(id);
        return bandBooking;
    }

    @Override
    public List<BandBooking> getAllBandBookings() {
        List<BandBooking> bandBookingList = bandBookingRepository.findAll();
        return bandBookingList;
    }


}
