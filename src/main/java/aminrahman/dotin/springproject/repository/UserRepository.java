package aminrahman.dotin.springproject.repository;

import aminrahman.dotin.springproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
