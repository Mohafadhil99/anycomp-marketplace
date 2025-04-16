package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Page<Seller> getAllSellers(Pageable pageable) {
        return sellerRepository.findAll(pageable);
    }

    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElseThrow();
    }

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller updateSeller(Long id, Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id).orElseThrow();
        seller.setName(sellerDetails.getName());
        seller.setEmail(sellerDetails.getEmail());
        return sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
