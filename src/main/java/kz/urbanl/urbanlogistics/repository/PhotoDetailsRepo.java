package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.PhotoDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDetailsRepo extends JpaRepository<PhotoDetails, Long> {
}
