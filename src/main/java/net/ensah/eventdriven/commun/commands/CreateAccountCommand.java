package net.ensah.eventdriven.commun.commands;

public class CreateAccountCommand<String> extends BaseCommand<String> {

    private double initialBalance;
    private String currency;

    public CreateAccountCommand(String command, double initialBalance, String currency) {
        super(command);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}
