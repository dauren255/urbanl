package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByStatus(Status status);
    List<Order> findAllByCompanyAndStatus(Company company, Status status);
}
