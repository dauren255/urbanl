package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
