package jak.dut.BookYourBand;

import jak.dut.BookYourBand.model.Band;
import jak.dut.BookYourBand.repository.BandRepository;
import jak.dut.BookYourBand.service.BandServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BandServiceImplTest {

    @Mock
    BandRepository bandRepository;

    @InjectMocks
    BandServiceImpl bandService;

    @Before
    public void loadData() {
        when(bandRepository.findAll()).thenReturn(listOfBandsForTests());
    }


    @Test
    public void shouldGetBandById() {
        List<Band> listOfBands = bandService.getAllBands();
        Long band = bandService.getBandById((long) 2).getId();
        when(bandService.getBandById((long) 2)).thenReturn((Band) listOfBands);

        Assert.assertEquals("Wpuszczeni w maliny", bandService.getBandById((long) 2).getBandName());
    }

    @Test
    public void shouldGetBandByNameTest() {
    }

    @Test
    public void shouldGetAllBandsTest() {
        List<Band> listOfBands = bandService.getAllBands();

        Assert.assertThat(listOfBands, Matchers.hasSize(3));
    }

    private List<Band> listOfBandsForTests() {
        List<Band> listOfBands = new ArrayList<>();
        listOfBands.add(new Band("Jama", "Ruda Slaska", 5.0));
        listOfBands.add(new Band("Wpuszczeni w maliny", "Chorzow", 4.9));
        listOfBands.add(new Band("Poparzeni herbata", "Gliwice", 4.5));
        return listOfBands;
    }
}