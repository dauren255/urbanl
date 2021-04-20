package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Mover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoverRepo extends JpaRepository<Mover, Long> {
}
