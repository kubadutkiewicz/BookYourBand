package jak.dut.BookYourBand.repository;

import jak.dut.BookYourBand.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUserName(String userName);

    Client findClientById(Long id);

}
