package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
}
