package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.model.Band;
import jak.dut.BookYourBand.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BandServiceImpl implements BandService{

    private final BandRepository bandRepository;

    public BandServiceImpl(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public Band getBandById(Long id) {
        return bandRepository.findBandById(id);
    }

    @Override
    public Band getBandByName(String bandName) {
        return bandRepository.findBandByBandName(bandName).orElseThrow(()-> new IllegalArgumentException("Band with name" + bandName + " not found"));
    }

    @Override
    public List<Band> getAllBands() {
        List<Band> allBands = new ArrayList<>();
        bandRepository.findAll().iterator().forEachRemaining(allBands::add);
        return allBands;
    }
}
