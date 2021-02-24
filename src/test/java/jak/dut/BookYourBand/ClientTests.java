package jak.dut.BookYourBand;

import jak.dut.BookYourBand.model.Client;
import jak.dut.BookYourBand.service.ClientService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTests {

    @Test
    public void shouldGetClientById() {
        ClientService clientService = mock(ClientService.class);

        when(clientService.getClientById((long) 1)).thenReturn(listOfClientsForTests().get(0));

        Assert.assertEquals("Kuba", clientService.getClientById((long) 1).getUserName());
        Assert.assertEquals("kuba@gmail.com", clientService.getClientById((long) 1).getEmail());
        Assert.assertEquals("ROLE_USER", clientService.getClientById((long) 1).getRole());
    }

    @Test
    public void shouldGetClientByName() {
        ClientService clientService = mock(ClientService.class);
        when(clientService.getClientByName("Kuba")).thenReturn(listOfClientsForTests().get(0));

        Assert.assertEquals("Kuba", clientService.getClientByName("Kuba").getUserName());
        Assert.assertEquals("ROLE_USER", clientService.getClientByName("Kuba").getRole());
        Assert.assertEquals("kuba@gmail.com", clientService.getClientByName("Kuba").getEmail());
    }

    private List<Client> listOfClientsForTests() {
        List<Client> listOfClients = new ArrayList<>();
        listOfClients.add(new Client("Kuba", "Kuba123", "kuba@gmail.com", "ROLE_USER"));
        listOfClients.add(new Client("Stefan", "Stefan123", "stefan@gmail.com", "ROLE_USER"));
        listOfClients.add(new Client("Franek", "Franek123", "franek@gmail.com", "ROLE_USER"));
        return listOfClients;
    }

}
