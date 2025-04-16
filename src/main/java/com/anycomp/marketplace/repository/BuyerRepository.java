package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
