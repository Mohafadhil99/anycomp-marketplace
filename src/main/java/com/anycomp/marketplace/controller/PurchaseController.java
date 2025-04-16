package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.dto.PurchaseRequest;
import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchase purchaseItem(@Valid @RequestBody PurchaseRequest request) {
        return purchaseService.purchaseItem(
                request.getBuyerId(),
                request.getItemId(),
                request.getQuantity()
        );
    }
}
