package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
