package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
}
