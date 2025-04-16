package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.service.SellerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public Page<Seller> getAllSellers(Pageable pageable) {
        return sellerService.getAllSellers(pageable);
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

    @PutMapping("/{id}")
    public Seller updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        return sellerService.updateSeller(id, seller);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
    }
}
