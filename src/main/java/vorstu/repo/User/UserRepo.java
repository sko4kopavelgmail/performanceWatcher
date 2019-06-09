package vorstu.repo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.User.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
