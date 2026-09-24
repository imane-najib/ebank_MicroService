package stage.ifm.ebankmicroservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.ifm.ebankmicroservice.dto.BankAccountRequestDTO;
import stage.ifm.ebankmicroservice.dto.BankAccountResponseDTO;
import stage.ifm.ebankmicroservice.entities.BankAccount;
import stage.ifm.ebankmicroservice.repositories.BankAccountRepository;
import stage.ifm.ebankmicroservice.service.AccountService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountService  accountService;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).
                orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveBankAccount(@RequestBody BankAccountRequestDTO RequestDTO) {

        return accountService.addAccount(RequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount saveBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCreateAt()!=null)account.setCreateAt(new Date());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
