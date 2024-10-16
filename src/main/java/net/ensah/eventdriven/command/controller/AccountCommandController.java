package net.ensah.eventdriven.command.controller;

import net.ensah.eventdriven.commun.dtos.CreateAccountRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commands/v1/accounts")
public class AccountCommandController {



    @PostMapping
    public void CreateNewAccount(CreateAccountRequestDto requestDto){

    }

}
