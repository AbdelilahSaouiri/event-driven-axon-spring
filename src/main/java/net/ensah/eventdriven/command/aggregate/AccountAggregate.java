package net.ensah.eventdriven.command.aggregate;

import net.ensah.eventdriven.commun.commands.CreateAccountCommand;
import net.ensah.eventdriven.commun.enums.AccountStatus;
import net.ensah.eventdriven.commun.events.AccountCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.ApplyMore;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
        //for axon necessary
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand<String> createAccountCommand) {
        //buisness logic
        if(createAccountCommand.getInitialBalance()<0)
            throw new IllegalArgumentException("Initial balance cannot be negative");

        ApplyMore apply = AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency()
        ));
    }

    //event sourcing handler
    //muter le cas d'application
   //pas de logique metier

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
     this.balance=event.getInitialBalance();
     this.currency=event.getCurrency();
     this.accountId=event.getId();
     this.status=AccountStatus.CREATED;
    }

}
