package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsernameIgnoreCase(String name);
}
