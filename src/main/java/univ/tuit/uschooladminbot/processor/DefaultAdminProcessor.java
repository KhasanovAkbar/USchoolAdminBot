package univ.tuit.uschooladminbot.processor;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import univ.tuit.uschooladminbot.handlers.AdminCallBackQuery;
import univ.tuit.uschooladminbot.handlers.AdminMessageHandler;

@Component
public class DefaultAdminProcessor implements AdminProcessor {

    private final AdminCallBackQuery adminCallBackQuery;
    private final AdminMessageHandler adminMessageHandler;

    public DefaultAdminProcessor(AdminCallBackQuery adminCallBackQuery, AdminMessageHandler adminMessageHandler) {
        this.adminCallBackQuery = adminCallBackQuery;
        this.adminMessageHandler = adminMessageHandler;
    }

    @Override
    public void executeQuery(Message message) {
        adminMessageHandler.choose(message);
    }

    @Override
    public void executeCallBackQuery(CallbackQuery callbackQuery) {
        adminCallBackQuery.choose(callbackQuery);
    }
}
