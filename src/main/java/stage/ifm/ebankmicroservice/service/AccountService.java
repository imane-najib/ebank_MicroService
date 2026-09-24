package stage.ifm.ebankmicroservice.service;

import stage.ifm.ebankmicroservice.dto.BankAccountRequestDTO;
import stage.ifm.ebankmicroservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
