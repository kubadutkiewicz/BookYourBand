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

import static org.mockito.Mockito.mock;
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
        when(bandService.getBandById((long) 1)).thenReturn(listOfBandsForTests().get(0));

        Assert.assertEquals("Jama", bandService.getBandById((long) 1).getBandName());
    }

    @Test
    public void shouldGetBandByNameTest() {
        BandServiceImpl bandService = mock(BandServiceImpl.class);
        Band band = new Band("Jama", "Ruda Slaska", 5.0);
        when(bandService.getBandByName("Jama")).thenReturn(band);

        Assert.assertEquals("Jama", bandService.getBandByName("Jama").getBandName());
        Assert.assertEquals("Ruda Slaska", bandService.getBandByName("Jama").getLocation());
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