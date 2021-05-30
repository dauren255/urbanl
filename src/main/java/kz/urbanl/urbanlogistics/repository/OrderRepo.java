package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.Company;
import kz.urbanl.urbanlogistics.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllByCompany(Company company);
}
