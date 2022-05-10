package univ.tuit.uschooladminbot.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import univ.tuit.uschooladminbot.services.AdminSendMessageService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AdminMessageHandler implements AdminHandler<Message> {

    @Autowired
    private AdminSendMessageService adminSendMessageService;

    @Override
    public void choose(Message message) {
        String user_first_name = message.getChat().getFirstName();
        String user_last_name = message.getChat().getLastName();
        long user_id = message.getChat().getId();
        String message_text = message.getText();
        String answer = message_text;
        if (message.hasText()) {
            log(user_first_name, user_last_name, Long.toString(user_id), message_text, answer);

            switch (message.getText()) {
                case "/start":
                    adminSendMessageService.getAll(message);
                    break;
                case "/restart":
                    break;
            }
        }

    }

    public static void log(String first_name, String last_name, String user_id, String txt, String bot_answer) {
        System.out.println("\n ----------------------------");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Message from " + first_name + " " + last_name + ". (id = " + user_id + ") \n Text - " + txt);
        System.out.println("Bot answer: \n Text - " + bot_answer);
    }
}
