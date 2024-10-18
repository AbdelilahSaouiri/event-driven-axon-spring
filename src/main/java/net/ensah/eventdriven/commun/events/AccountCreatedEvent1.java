package net.ensah.eventdriven.commun.events;

import net.ensah.eventdriven.commun.enums.AccountStatus;

public record AccountCreatedEvent1(double initialBalance, String currency, AccountStatus status,BaseEvent<String> baseEvent) {

     public AccountCreatedEvent1(double initialBalance, String currency, AccountStatus status) {
         this(initialBalance, currency, status, new BaseEvent<String>("") {
             @Override
             public String getId() {
                 return super.getId();
             }
         });
     }


}
