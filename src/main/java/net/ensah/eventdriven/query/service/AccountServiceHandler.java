package net.ensah.eventdriven.query.service;

import lombok.extern.slf4j.Slf4j;
import net.ensah.eventdriven.commun.events.AccountCreatedEvent;
import net.ensah.eventdriven.query.entity.Account;
import net.ensah.eventdriven.query.repository.AccountRepository;
import net.ensah.eventdriven.query.repository.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
}
