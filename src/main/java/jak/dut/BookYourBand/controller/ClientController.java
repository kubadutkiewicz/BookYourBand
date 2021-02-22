package jak.dut.BookYourBand.controller;

import jak.dut.BookYourBand.model.Token;
import jak.dut.BookYourBand.repository.TokenRepository;
import jak.dut.BookYourBand.repository.ClientRepository;
import jak.dut.BookYourBand.service.ClientService;
import jak.dut.BookYourBand.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final TokenRepository tokenRepository;
    private final ClientRepository clientRepository;

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
    public String tokenAuthorisation(@RequestParam String value) {
        Token tokenWithValue = tokenRepository.findByValue(value);
        Client client = tokenWithValue.getClient();
        client.setEnabled(true);
        clientRepository.save(client);
        return "welcome";
    }
}
