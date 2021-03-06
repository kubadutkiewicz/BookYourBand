package jak.dut.BookYourBand.controller;

import jak.dut.BookYourBand.service.BandService;
import jak.dut.BookYourBand.model.Band;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bands")
public class BandController {

    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping
    @ResponseBody
    public List<Band> getAllBands() {
        return bandService.getAllBands();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Band getBandById(@PathVariable("id") Long id) {
        return bandService.getBandById(id);
    }
}
