package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Model.Client;
import jak.dut.BookYourBand.Model.Token;
import jak.dut.BookYourBand.Repository.ClientRepository;
import jak.dut.BookYourBand.Repository.TokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;
    private TokenRepository tokenRepository;
    private MailService mailService;

    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository, MailService mailService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
        this.mailService = mailService;
    }

    public void addClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setEmail(client.getEmail());
        client.setRole("ROLE_USER");
        clientRepository.save(client);
        sendToken(client);
    }

    private void sendToken(Client client) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setClient(client);
        tokenRepository.save(token);
        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(client.getEmail(), "Potwierdzenie rejestracji w aplikacji Book Your Band", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Client getClientById(Long id) {
        return clientRepository.findClientById(id);
    }
}
