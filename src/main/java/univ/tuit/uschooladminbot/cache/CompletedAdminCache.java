package univ.tuit.uschooladminbot.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import univ.tuit.uschooladminbot.domain.CompletedUser;
import univ.tuit.uschooladminbot.domain.Status;
import univ.tuit.uschooladminbot.repo.CompletedUserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class CompletedAdminCache implements AdminCache<CompletedUser> {

    @Autowired
    CompletedUserRepository completed;

    @Override
    public List<CompletedUser> getAll() {
        List<CompletedUser> all = completed.findAll();
        List<CompletedUser> completedUsers = new ArrayList<>();

        for (CompletedUser completedUser : all) {
            if (completedUser.getStatus().equals(Status.NEW.name()))
                completedUsers.add(completedUser);
            completedUser.setStatus(Status.SHOWN.name());
            completed.save(completedUser);
        }
        return completedUsers;
    }
}
