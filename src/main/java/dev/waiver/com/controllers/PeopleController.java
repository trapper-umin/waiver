package dev.waiver.com.controllers;

import dev.waiver.com.bot.config.BotConfig;
import dev.waiver.com.controllers.abstracts.ImplPeopleController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/people")
public class PeopleController extends ImplPeopleController {

    private final BotConfig botConfig;

    public PeopleController(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @GetMapping
    public String sds(){

        StringBuilder message=new StringBuilder();

        message.append(botConfig.getToken()).append(" ").append(botConfig.getBotUsername());

        return message.toString();
    }
}
