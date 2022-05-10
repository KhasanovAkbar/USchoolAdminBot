package univ.tuit.uschooladminbot.messageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import univ.tuit.uschooladminbot.AdminBotMain;

@Service
public class AdminMessageSenderImpl implements AdminMessageSender {

    @Autowired
    private AdminBotMain adminBotMain;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            adminBotMain.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
