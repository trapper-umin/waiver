package dev.waiver.com.bot.config;

import dev.waiver.com.bot.WaiverBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInit {

    private final WaiverBot waiverBot;

    public BotInit(WaiverBot waiverBot) {
        this.waiverBot = waiverBot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init()throws TelegramApiException{
        TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(waiverBot);
        }catch (TelegramApiException e){

        }
    }
}
