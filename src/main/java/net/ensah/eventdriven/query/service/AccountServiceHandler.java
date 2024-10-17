package net.ensah.eventdriven.query.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.ensah.eventdriven.commun.GetAllAccountsQuery;
import net.ensah.eventdriven.commun.events.AccountCreatedEvent;
import net.ensah.eventdriven.query.entity.Account;
import net.ensah.eventdriven.query.repository.AccountRepository;
import net.ensah.eventdriven.query.repository.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class AccountServiceHandler {

    private final AccountRepository accountRepository;
    private final OperationRepository operationRepository;

    public AccountServiceHandler(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        // pas de logique metier

        log.info("add new account: {}", event);
        accountRepository.save(new Account(
               event.getId(),
                event.getInitialBalance(),
                event.getStatus(),
                event.getCurrency(),
               null
        ));
    }

    @QueryHandler
    public List<Account>  getAllAccounts(GetAllAccountsQuery query) {
        return accountRepository.findAll();
    }
}
