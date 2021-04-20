package kz.urbanl.urbanlogistics.repository;

import kz.urbanl.urbanlogistics.model.CardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDataRepo extends JpaRepository<CardData, Long> {
}
