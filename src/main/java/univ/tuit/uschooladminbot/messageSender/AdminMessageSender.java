package univ.tuit.uschooladminbot.messageSender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface AdminMessageSender {

    void sendMessage(SendMessage sendMessage);
}
