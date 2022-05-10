package univ.tuit.uschooladminbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import univ.tuit.uschooladminbot.processor.AdminProcessor;

@Component
public class AdminBotMain extends TelegramLongPollingBot {

    @Value("${telegram.adminbot.username}")
    private String username;

    @Value("${telegram.adminbot.token}")
    private String token;

    @Autowired
    private AdminProcessor adminProcessor;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        adminProcessor.processor(update);
    }
}
