package univ.tuit.uschooladminbot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class AdminCallBackQuery implements AdminHandler<CallbackQuery> {


    @Override
    public void choose(CallbackQuery callbackQuery) {

    }
}
