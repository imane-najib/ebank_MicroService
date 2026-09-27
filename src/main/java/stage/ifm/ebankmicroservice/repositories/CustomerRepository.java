package stage.ifm.ebankmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stage.ifm.ebankmicroservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
