package net.ensah.eventdriven.command.controller;

import net.ensah.eventdriven.commun.commands.CreateAccountCommand;
import net.ensah.eventdriven.commun.dtos.CreateAccountRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/commands/v1/accounts")
public class AccountCommandController {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public AccountCommandController(CommandGateway cmdGateway, EventStore eventStore) {
        this.commandGateway = cmdGateway;
        this.eventStore = eventStore;
    }


    @PostMapping
    public  CompletableFuture<String> CreateNewAccount(@RequestBody CreateAccountRequestDto requestDto){
        return commandGateway.send(new CreateAccountCommand<>(
                UUID.randomUUID().toString(),
                requestDto.initialBalance(),
                requestDto.currency()
        ));
    }

    @GetMapping("/{accountId}")
    public Stream<?> eventStore(@PathVariable String accountId){
        return eventStore.readEvents(accountId).asStream();
    }

}
