package univ.tuit.uschooladminbot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import univ.tuit.uschooladminbot.cache.AdminCache;
import univ.tuit.uschooladminbot.domain.CompletedUser;
import univ.tuit.uschooladminbot.messageSender.AdminMessageSender;

import java.util.List;


@Service
public class AdminSendMessageService implements AdminSendMessageImpl<Message> {

    private final AdminMessageSender adminMessageSender;
    private final AdminCache<CompletedUser> adminCache;

    public AdminSendMessageService(AdminMessageSender adminMessageSender, AdminCache<CompletedUser> adminCache) {
        this.adminMessageSender = adminMessageSender;
        this.adminCache = adminCache;
    }


    @Override
    public void getAll(Message message) {

        List<CompletedUser> all = adminCache.getAll();

        for (CompletedUser byUserId : all) {
            adminMessageSender.sendMessage(SendMessage.builder().text("<b>FISH: </b>" + byUserId.getName() + " " + byUserId.getSurname() +
                            "\n<b>username: </b>" + "@" + byUserId.getUsername() +
                            "\n<b>Phone number: </b>" + byUserId.getPhoneNumber() +
                            "\n<b>Age: </b>" + byUserId.getAge())
                    .parseMode("HTML")
                    .chatId(String.valueOf(message.getChatId()))
                    .build());
        }

    }
}
