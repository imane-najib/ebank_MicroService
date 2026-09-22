package stage.ifm.ebankmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.ifm.ebankmicroservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
