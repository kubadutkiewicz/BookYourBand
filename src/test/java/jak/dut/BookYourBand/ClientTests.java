package jak.dut.BookYourBand;

import jak.dut.BookYourBand.model.Client;
import jak.dut.BookYourBand.service.ClientService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTests {

    @Test
    public void shouldGetClientById() {
        ClientService clientService = mock(ClientService.class);
        Client client = new Client((long) 1, "Kuba", "Kuba123", "kuba@kuba.com", "ROLE_USER");

        when(clientService.getClientById((long) 1)).thenReturn(client);

        Assert.assertEquals("Kuba", clientService.getClientById((long) 1).getUserName());
        Assert.assertEquals("kuba@kuba.com", clientService.getClientById((long) 1).getEmail());
        Assert.assertEquals("ROLE_USER", clientService.getClientById((long) 1).getRole());
    }

    @Test
    public void shouldGetClientByName() {
        ClientService clientService = mock(ClientService.class);
        Client client = new Client((long) 1, "Kuba", "Kuba123", "kuba@kuba.com", "ROLE_USER");

        when(clientService.getClientByName("Kuba")).thenReturn(client);

        Assert.assertEquals("Kuba", clientService.getClientByName("Kuba").getUserName());
        Assert.assertEquals("ROLE_USER", clientService.getClientByName("Kuba").getRole());
        Assert.assertEquals("kuba@kuba.com", clientService.getClientByName("Kuba").getEmail());
    }

}
