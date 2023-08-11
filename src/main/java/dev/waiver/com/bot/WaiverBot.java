package dev.waiver.com.bot;

import dev.waiver.com.bot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class WaiverBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;

    public WaiverBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println("sdsdsdsdsds");

        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageText=update.getMessage().getText();
            Message command=update.getMessage();
            long chatID=update.getMessage().getChatId();

            System.out.println("ID: "+chatID+ "\n"+"Message: "+messageText+"\n"+"Command: "+command.toString());

            switch (messageText){
                case "/start" -> {
                    doCommand(command);
                    break;
                }
                default -> {
                    break;
                }
            }

        }
    }

    private void doCommand(Message command){

        try {
            execute(SendMessage.builder()
                    .chatId(command.getChatId().toString())
                    .parseMode("Markdown")
                    .text("Hello, world!")
                    .build()
            );
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

}
