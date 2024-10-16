package net.ensah.eventdriven.commun.events;


import lombok.Getter;

@Getter
public class AccountCreatedEvent extends BaseEvent<String>{

     // ce qu'on va garder dans event store
     private final double initialBalance;
     private final String currency;

     public AccountCreatedEvent(String id, double initialBalance, String currency) {
        super(id);
         this.initialBalance = initialBalance;
         this.currency = currency;
     }
}
