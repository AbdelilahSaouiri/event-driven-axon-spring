package net.ensah.eventdriven.commun.commands;

public class DebitAccountCommand<String> extends BaseCommand<String> {

    private double amount;
    private String currency;

    public DebitAccountCommand(String command, double amount, String currency) {
        super(command);
        this.amount = amount;
        this.currency = currency;
    }
}
