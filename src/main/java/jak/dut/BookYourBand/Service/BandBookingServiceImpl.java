package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Exeption.BookingUnavailableBandException;
import jak.dut.BookYourBand.Model.Band;
import jak.dut.BookYourBand.Model.BandBooking;
import jak.dut.BookYourBand.Model.Client;
import jak.dut.BookYourBand.Repository.BandBookingRepository;
import jak.dut.BookYourBand.Repository.BandRepository;
import jak.dut.BookYourBand.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandBookingServiceImpl implements BandBookingService {

    private BandBookingRepository bandBookingRepository;
    private BandRepository bandRepository;
    private ClientRepository clientRepository;

    public BandBookingServiceImpl(BandBookingRepository bandBookingRepository, BandRepository bandRepository, ClientRepository clientRepository) {
        this.bandBookingRepository = bandBookingRepository;
        this.bandRepository = bandRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BandBooking addBandBooking(Long clientId, Long bandId, String date) throws BookingUnavailableBandException {
        Client client = clientRepository.findClientById(clientId);
        Band band = bandRepository.findBandById(bandId);
        BandBooking reserverBand = new BandBooking("14/02/2021", client, band);
        bandBookingRepository.save(reserverBand);
        return reserverBand;
    }

    @Override
    public BandBooking getBandBookingById(Long id) {
        return bandBookingRepository.findBandBookingById(id);
    }

    @Override
    public List<BandBooking> getAllBandBookings() {
        return bandBookingRepository.findAll();
    }
}
