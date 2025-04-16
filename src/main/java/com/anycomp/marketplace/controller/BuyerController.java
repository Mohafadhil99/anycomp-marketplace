package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.service.BuyerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping
    public Page<Buyer> getAllBuyers(Pageable pageable) {
        return buyerService.getAllBuyers(pageable);
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable Long id) {
        return buyerService.getBuyerById(id).orElseThrow();
    }

    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    @PutMapping("/{id}")
    public Buyer updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
        return buyerService.updateBuyer(id, buyer);
    }

    @DeleteMapping("/{id}")
    public void deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
    }
}
