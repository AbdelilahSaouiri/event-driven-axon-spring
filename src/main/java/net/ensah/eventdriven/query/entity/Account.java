package net.ensah.eventdriven.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ensah.eventdriven.commun.enums.AccountStatus;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Account {
     @Id
    private String accountId;
    private double balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private String currency;
    @OneToMany(targetEntity = Operation.class,mappedBy ="account")
    private List<Operation> operations;
}
