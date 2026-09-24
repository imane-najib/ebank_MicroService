package stage.ifm.ebankmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stage.ifm.ebankmicroservice.dto.BankAccountRequestDTO;
import stage.ifm.ebankmicroservice.dto.BankAccountResponseDTO;
import stage.ifm.ebankmicroservice.entities.BankAccount;
import stage.ifm.ebankmicroservice.mappers.AccountMapper;
import stage.ifm.ebankmicroservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())

                .build();
        BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
