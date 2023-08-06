package pl.camp.it.spring.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends org.springframework.data.repository.Repository<User, Integer> {
    User save(User entity);
    Optional<User> findById(Integer id);
    Optional<User> findByLogin(String login);
    Optional<User> findByLoginAndId(String login, Integer id);
    @Query(value = "SELECT * FROM tuser WHERE id < 5", nativeQuery = true)
    List<User> findUserWhereIdLessThan5();
}
