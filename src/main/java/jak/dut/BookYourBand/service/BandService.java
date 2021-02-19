package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.model.Band;

import java.util.List;

public interface BandService {

    Band getBandById(Long id);

    Band getBandByName(String bandName);

    List<Band> getAllBands();

}
