package stage.ifm.ebankmicroservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import stage.ifm.ebankmicroservice.dto.BankAccountResponseDTO;
import stage.ifm.ebankmicroservice.entities.BankAccount;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

}
