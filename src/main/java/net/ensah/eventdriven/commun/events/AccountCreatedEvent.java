package net.ensah.eventdriven.commun.events;


import lombok.Getter;
import net.ensah.eventdriven.commun.enums.AccountStatus;

@Getter
public class AccountCreatedEvent extends BaseEvent<String>{

     // ce qu'on va garder dans event store
     private final double initialBalance;
     private final String currency;
     private final AccountStatus status;
     public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus status) {
        super(id);
         this.initialBalance = initialBalance;
         this.currency = currency;
         this.status = status;
     }
}
