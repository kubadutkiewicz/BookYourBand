package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.model.Band;
import jak.dut.BookYourBand.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    private final BandRepository bandRepository;

    public BandServiceImpl(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public Band getBandById(Long id) {
        Band band = bandRepository.findBandById(id);
        return band;
    }

    @Override
    public Band getBandByName(String bandName) {
        Band band = bandRepository.findBandByBandName(bandName).orElseThrow(() -> new IllegalArgumentException("Band with name " + bandName + " not found"));
        return band;
    }

    @Override
    public List<Band> getAllBands() {
        List<Band> allBands = new ArrayList<>();
        bandRepository.findAll().iterator().forEachRemaining(allBands::add);
        return allBands;
    }
}
