package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Status;
import kz.urbanl.urbanlogistics.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsernameIgnoreCase(String name);
    List<User> findAllByStatus(Status status);
    User findUserById(Long id);
    List<User> findAllByAccountNonExpired(boolean accountNonExpired);
}
