package org.trackcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trackcoin.model.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
}
