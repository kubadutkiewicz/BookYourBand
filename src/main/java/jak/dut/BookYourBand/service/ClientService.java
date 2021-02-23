package jak.dut.BookYourBand.service;

import jak.dut.BookYourBand.model.Token;
import jak.dut.BookYourBand.repository.TokenRepository;
import jak.dut.BookYourBand.model.Client;
import jak.dut.BookYourBand.repository.ClientRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final MailService mailService;

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

    String getCurrentClient(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    public Client getClientById(Long id) {
        return clientRepository.findClientById(id).orElseThrow(()-> new IllegalArgumentException("Client with id: " + id + " not found."));
    }

    public Client getClientByName(String name) {
        return clientRepository.findByUserName(name).orElseThrow(()-> new IllegalArgumentException("Client with name: " + name + "not found."));
    }

}
