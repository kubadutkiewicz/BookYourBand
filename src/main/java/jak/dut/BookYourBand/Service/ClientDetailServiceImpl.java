package jak.dut.BookYourBand.Service;

import jak.dut.BookYourBand.Repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailServiceImpl implements UserDetailsService {

    private ClientRepository clientRepository;

    public ClientDetailServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return clientRepository.findByUserName(s).get();
    }
}
