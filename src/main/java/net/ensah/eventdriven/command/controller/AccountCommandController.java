package net.ensah.eventdriven.command.controller;

import net.ensah.eventdriven.commun.commands.CreateAccountCommand;
import net.ensah.eventdriven.commun.dtos.CreateAccountRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/commands/v1/accounts")
public class AccountCommandController {

    private final CommandGateway commandGateway;

    public AccountCommandController(CommandGateway cmdGateway) {
        this.commandGateway = cmdGateway;
    }


    @PostMapping
    public  CompletableFuture<String> CreateNewAccount(@RequestBody CreateAccountRequestDto requestDto){
        return commandGateway.send(new CreateAccountCommand<>(
                UUID.randomUUID().toString(),
                requestDto.initialBalance(),
                requestDto.currency()
        ));
    }

}
