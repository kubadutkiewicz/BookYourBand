package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Model.Band;
import jak.dut.BookYourBand.Repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandServiceImpl implements BandService{

    private BandRepository bandRepository;

    public BandServiceImpl(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public Band getBandById(Long id) {
        return bandRepository.findBandById(id);
    }

    @Override
    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }
}
