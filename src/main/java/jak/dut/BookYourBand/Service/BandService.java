package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Model.Band;

import java.util.List;

public interface BandService {

    Band getBandById(Long id);

    List<Band> getAllBands();

}
