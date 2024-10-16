package net.ensah.eventdriven.commun.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {

    @TargetAggregateIdentifier
    @Getter private T command;

    public BaseCommand(T command) {
        this.command = command;
    }
}
