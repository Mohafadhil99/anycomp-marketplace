package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.repository.BuyerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Page<Buyer> getAllBuyers(Pageable pageable) {
        return buyerRepository.findAll(pageable);
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(Long id, Buyer buyerDetails) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow();
        buyer.setName(buyerDetails.getName());
        buyer.setEmail(buyerDetails.getEmail());
        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }
}
