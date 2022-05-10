package univ.tuit.uschooladminbot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import univ.tuit.uschooladminbot.domain.CompletedUser;

public interface CompletedUserRepository extends JpaRepository<CompletedUser, Long> {

    CompletedUser getByUserId(Long id);
}