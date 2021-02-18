package jak.dut.BookYourBand.Controller;

import jak.dut.BookYourBand.Repository.ClientRepository;
import jak.dut.BookYourBand.Service.ClientService;
import jak.dut.BookYourBand.Model.Client;
import jak.dut.BookYourBand.Model.Token;
import jak.dut.BookYourBand.Repository.TokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ClientController {

    private ClientService clientService;
    private TokenRepository tokenRepository;
    private ClientRepository clientRepository;

    public ClientController(ClientService clientService, TokenRepository tokenRepository, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.tokenRepository = tokenRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/welcome")
    public String welcome(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return "welcome";
    }

    @GetMapping("/sing-up")
    public String singup(Model model) {
        model.addAttribute("client", new Client());
        return "singuptemplate";
    }

    @PostMapping("/register")
    public String register(Client client) {
        clientService.addClient(client);
        return "welcome";
    }

    @GetMapping("/token")
    public String token(@RequestParam String value) {
        Token byValue = tokenRepository.findByValue(value);
        Client client = byValue.getClient();
        client.setEnabled(true);
        clientRepository.save(client);
        return "welcome";
    }
}
