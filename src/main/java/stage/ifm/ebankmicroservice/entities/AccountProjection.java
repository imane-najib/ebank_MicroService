package stage.ifm.ebankmicroservice.entities;

import org.springframework.data.rest.core.config.Projection;
import stage.ifm.ebankmicroservice.enums.AccountType;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
