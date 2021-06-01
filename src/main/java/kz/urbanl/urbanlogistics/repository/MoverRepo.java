package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Mover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoverRepo extends JpaRepository<Mover, Long> {
    List<Mover> findAllByCompany(Company company);
}
